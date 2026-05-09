package com.company.orders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer order. Holds line items and computed financials.
 */
public class Order {
    private String orderId;
    private Customer customer;
    private List<OrderItem> items;
    private LocalDateTime placedAt;
    private String status; // "PENDING", "CONFIRMED", "SHIPPED", "CANCELLED"

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.placedAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    public void addItem(Product product, int quantity) {
        items.add(new OrderItem(product, quantity));
    }

    public double getTotalBeforeDiscount() {
        return items.stream()
                .mapToDouble(i -> i.getProduct().getUnitPrice() * i.getQuantity())
                .sum();
    }

    public String getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public List<OrderItem> getItems() { return items; }
    public LocalDateTime getPlacedAt() { return placedAt; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
