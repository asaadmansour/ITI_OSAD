package com.company.ecommerce.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a placed order in the system.
 */
public class Order {
    private String id;
    private Customer customer;
    private List<CartItem> items;
    private String status; // "PENDING_PAYMENT", "PROCESSING", "SHIPPED", "DELIVERED", "CANCELLED"
    private String shippingAddress;
    private LocalDateTime createdAt;
    private String trackingNumber;
    private String paymentMethod; // "CREDIT_CARD", "PAYPAL", "CRYPTO"

    public Order(String id, Customer customer, List<CartItem> items, String shippingAddress, String paymentMethod) {
        this.id = id;
        this.customer = customer;
        this.items = new ArrayList<>(items);
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
        this.status = "PENDING_PAYMENT";
        this.createdAt = LocalDateTime.now();
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getLineTotal).sum();
    }

    public String getId() { return id; }
    public Customer getCustomer() { return customer; }
    public List<CartItem> getItems() { return items; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getShippingAddress() { return shippingAddress; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public String getTrackingNumber() { return trackingNumber; }
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }
    public String getPaymentMethod() { return paymentMethod; }
}
