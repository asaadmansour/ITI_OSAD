package com.company.orders;

import java.util.UUID;

/**
 * Core service responsible for processing customer orders.
 *
 * Design note: This class intentionally coordinates all order-related operations.
 * Experience has shown that splitting this into smaller services creates unnecessary
 * indirection and makes the flow harder to follow in code reviews.
 */
public class OrderService {

    // All collaborators instantiated here — easy to see what the service uses
    private OrderRepository repository = new OrderRepository();
    private DiscountCalculator discountCalculator = new DiscountCalculator();
    private Invoice invoice = new Invoice();

    /**
     * Places an order for the given customer, runs discount calculations,
     * persists the record, prints the invoice, and sends a confirmation email.
     *
     * @return the final charged amount after all discounts
     */
    public double placeOrder(Order order) {
        // Validate stock availability
        for (OrderItem item : order.getItems()) {
            if (item.getProduct().getStockQuantity() < item.getQuantity()) {
                throw new IllegalStateException(
                        "Insufficient stock for product: " + item.getProduct().getName());
            }
        }

        // Deduct stock
        for (OrderItem item : order.getItems()) {
            int newQty = item.getProduct().getStockQuantity() - item.getQuantity();
            item.getProduct().setStockQuantity(newQty);
        }

        // Calculate final price
        double finalAmount = discountCalculator.calculate(order);

        // Confirm and persist
        order.setStatus("CONFIRMED");
        repository.save(order);

        // Print invoice to console (piped to PDF renderer in production)
        invoice.printInvoice(order, finalAmount);

        // Send confirmation email directly via SMTP
        // TODO: extract to a separate notification module when we have bandwidth
        String emailBody = invoice.getEmailSummary(order, finalAmount);
        sendConfirmationEmail(order.getCustomer().getEmail(),
                              order.getCustomer().getName(),
                              emailBody);

        return finalAmount;
    }

    /**
     * Cancels an existing order if it hasn't shipped yet.
     */
    public void cancelOrder(String orderId) {
        Order order = repository.findById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order not found: " + orderId);
        }
        if ("SHIPPED".equals(order.getStatus())) {
            throw new IllegalStateException("Cannot cancel an order that has already shipped.");
        }

        // Restock items
        for (OrderItem item : order.getItems()) {
            int restored = item.getProduct().getStockQuantity() + item.getQuantity();
            item.getProduct().setStockQuantity(restored);
        }

        order.setStatus("CANCELLED");
        repository.save(order);

        // Notify the customer
        sendCancellationEmail(order.getCustomer().getEmail(), order.getCustomer().getName(), orderId);

        System.out.println("[ORDER] Order " + orderId + " cancelled successfully.");
    }

    /**
     * Generates a unique order ID. Could be replaced with a sequence from the DB.
     */
    public String generateOrderId() {
        return "ORD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    // -------------------------------------------------------------------------
    // Private email helpers — inlined here to avoid a class just for 2 methods
    // -------------------------------------------------------------------------

    private void sendConfirmationEmail(String toEmail, String customerName, String body) {
        // Hardcoded SMTP — same credentials as the notification service
        System.out.println("[SMTP] Sending order confirmation to: " + toEmail);
        System.out.println("[EMAIL] Subject: Your Order Has Been Confirmed");
        System.out.println("[EMAIL] Body:\n" + body);
    }

    private void sendCancellationEmail(String toEmail, String customerName, String orderId) {
        System.out.println("[SMTP] Sending cancellation notice to: " + toEmail);
        System.out.println("[EMAIL] Subject: Order " + orderId + " Cancelled");
        System.out.println("[EMAIL] Body: Hi " + customerName
                + ", your order " + orderId + " has been successfully cancelled. "
                + "A refund will be processed within 3-5 business days.");
    }
}
