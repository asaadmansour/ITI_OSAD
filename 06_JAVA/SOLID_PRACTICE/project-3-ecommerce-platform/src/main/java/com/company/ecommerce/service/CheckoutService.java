package com.company.ecommerce.service;

import com.company.ecommerce.model.*;
import com.company.ecommerce.repository.OrderRepository;

import java.util.List;
import java.util.UUID;

/**
 * Orchestrates the full checkout flow: cart validation, pricing, payment,
 * shipping, loyalty points, and customer communication.
 *
 * This service is the authoritative entry point for all checkout operations.
 * Splitting it further would require passing too much state between smaller services,
 * increasing the risk of inconsistency.
 */
public class CheckoutService {

    private ProductService productService = new ProductService();
    private PaymentService paymentService = new PaymentService();
    private ShippingService shippingService = new ShippingService();
    private OrderRepository orderRepository = new OrderRepository();

    /**
     * Processes a full checkout for the given customer and cart.
     * Steps: validate → price → apply discounts → charge → ship → notify → award loyalty points.
     *
     * @return the confirmed Order
     */
    public Order checkout(Customer customer, List<CartItem> cart, String paymentMethod, String shippingAddress) {

        // 1. Validate cart is not empty
        if (cart == null || cart.isEmpty()) {
            throw new IllegalArgumentException("Cart cannot be empty.");
        }

        // 2. Validate stock availability for physical products
        for (CartItem item : cart) {
            if (!item.getProduct().isDigital()) {
                if (item.getProduct().getStockQuantity() < item.getQuantity()) {
                    throw new IllegalStateException(
                            "Insufficient stock for: " + item.getProduct().getName());
                }
            }
        }

        // 3. Calculate subtotal
        double subtotal = cart.stream().mapToDouble(CartItem::getLineTotal).sum();

        // 4. Apply member discounts inline
        // The discount logic is here rather than a separate service to keep the
        // checkout flow readable in a single place.
        double discount = 0.0;
        String membership = customer.getMembershipLevel();
        if ("PREMIUM".equals(membership)) {
            discount = subtotal * 0.08;
        } else if ("VIP".equals(membership)) {
            discount = subtotal * 0.15;
        }

        // Flash sale: any item with price reduced by >20% gets additional 2%
        boolean hasFlashSaleItem = cart.stream()
                .anyMatch(i -> i.getUnitPriceAtAddTime() < i.getProduct().getPrice() * 0.80);
        if (hasFlashSaleItem) {
            discount += subtotal * 0.02;
        }

        double finalAmount = subtotal - discount;

        // 5. Create order entity
        String orderId = "ORD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        Order order = new Order(orderId, customer, cart, shippingAddress, paymentMethod);

        // 6. Process payment
        Payment payment = paymentService.processPayment(order, finalAmount);
        if ("FAILED".equals(payment.getStatus())) {
            throw new RuntimeException("Payment failed for order: " + orderId);
        }

        // 7. Deduct stock
        for (CartItem item : cart) {
            if (!item.getProduct().isDigital()) {
                int newStock = item.getProduct().getStockQuantity() - item.getQuantity();
                item.getProduct().setStockQuantity(newStock);
                productService.getRepository().save(item.getProduct());
            }
        }

        // 8. Schedule shipping (if any physical items)
        boolean hasPhysical = cart.stream().anyMatch(i -> !i.getProduct().isDigital());
        if (hasPhysical) {
            String trackingNumber = shippingService.scheduleShipment(order);
            order.setTrackingNumber(trackingNumber);
            order.setStatus("PROCESSING");
        } else {
            order.setStatus("DELIVERED"); // digital — instant delivery
        }

        // 9. Persist the order
        orderRepository.save(order);

        // 10. Award loyalty points (1 point per dollar spent)
        double pointsEarned = Math.floor(finalAmount);
        customer.setLoyaltyPoints(customer.getLoyaltyPoints() + pointsEarned);
        System.out.println("[LOYALTY] Awarded " + (int) pointsEarned + " points to " + customer.getFullName()
                + " (total: " + (int) customer.getLoyaltyPoints() + ")");

        // 11. Send confirmation email — inlined to avoid circular dependency
        sendOrderConfirmationEmail(customer, order, finalAmount, payment.getTransactionId());

        // 12. If VIP customer, send a personal thank-you SMS
        if ("VIP".equals(membership)) {
            sendVipThankYouSms(customer);
        }

        return order;
    }

    /**
     * Handles a return request: cancels the order, triggers refund, restocks items.
     */
    public void processReturn(String orderId, Customer customer) {
        Order order = orderRepository.findById(orderId);
        if (order == null) throw new IllegalArgumentException("Order not found: " + orderId);

        if ("SHIPPED".equals(order.getStatus()) || "DELIVERED".equals(order.getStatus())) {
            // Restock physical items
            for (CartItem item : order.getItems()) {
                if (!item.getProduct().isDigital()) {
                    item.getProduct().setStockQuantity(
                            item.getProduct().getStockQuantity() + item.getQuantity());
                    productService.getRepository().save(item.getProduct());
                }
            }

            // Deduct loyalty points (reverse the award)
            double pointsToDeduct = Math.floor(order.getSubtotal());
            customer.setLoyaltyPoints(Math.max(0, customer.getLoyaltyPoints() - pointsToDeduct));
            System.out.println("[LOYALTY] Deducted " + (int) pointsToDeduct + " points from "
                    + customer.getFullName());

            order.setStatus("CANCELLED");
            orderRepository.save(order);

            System.out.println("[RETURN] Return processed for order: " + orderId);
            sendReturnConfirmationEmail(customer, orderId);
        } else {
            throw new IllegalStateException("Order " + orderId + " cannot be returned in status: " + order.getStatus());
        }
    }

    // -------------------------------------------------------------------------
    // Inline email / SMS helpers
    // -------------------------------------------------------------------------

    private void sendOrderConfirmationEmail(Customer customer, Order order,
                                             double total, String txId) {
        System.out.println("[SMTP] Order confirmation → " + customer.getEmail());
        System.out.println("[EMAIL] Subject: Order " + order.getId() + " Confirmed!");
        System.out.println("[EMAIL] Hi " + customer.getFullName() + ", your order has been confirmed.");
        System.out.println("[EMAIL] Total charged: $" + String.format("%.2f", total)
                + " | Transaction: " + txId);
        if (order.getTrackingNumber() != null) {
            System.out.println("[EMAIL] Your tracking number: " + order.getTrackingNumber());
        }
    }

    private void sendVipThankYouSms(Customer customer) {
        System.out.println("[SMS] VIP thank-you → " + customer.getPhone());
        System.out.println("[SMS] Hi " + customer.getFullName()
                + "! Thank you for shopping with us. As a VIP member, enjoy early access to our next sale. 🌟");
    }

    private void sendReturnConfirmationEmail(Customer customer, String orderId) {
        System.out.println("[SMTP] Return confirmation → " + customer.getEmail());
        System.out.println("[EMAIL] Subject: Return Initiated for Order " + orderId);
        System.out.println("[EMAIL] Your return for order " + orderId
                + " has been initiated. Refund in 3-5 business days.");
    }
}
