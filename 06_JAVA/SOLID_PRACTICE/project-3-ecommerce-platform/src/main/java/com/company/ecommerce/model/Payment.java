package com.company.ecommerce.model;

import java.time.LocalDateTime;

/**
 * Represents a payment transaction tied to an order.
 */
public class Payment {
    private String transactionId;
    private String orderId;
    private double amount;
    private String method;   // "CREDIT_CARD", "PAYPAL", "CRYPTO"
    private String status;   // "SUCCESS", "FAILED", "PENDING", "REFUNDED"
    private LocalDateTime processedAt;

    public Payment(String transactionId, String orderId, double amount, String method, String status) {
        this.transactionId = transactionId;
        this.orderId = orderId;
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.processedAt = LocalDateTime.now();
    }

    public String getTransactionId() { return transactionId; }
    public String getOrderId() { return orderId; }
    public double getAmount() { return amount; }
    public String getMethod() { return method; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getProcessedAt() { return processedAt; }
}
