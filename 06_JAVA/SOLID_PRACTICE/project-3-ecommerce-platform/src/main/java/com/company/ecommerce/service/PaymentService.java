package com.company.ecommerce.service;

import com.company.ecommerce.model.Order;
import com.company.ecommerce.model.Payment;

import java.util.UUID;

/**
 * Handles all payment processing logic.
 *
 * Currently supports three payment providers: Stripe (credit cards),
 * PayPal, and CoinGate (crypto). Provider selection is based on the
 * payment method stored on the order.
 *
 * Design note: We intentionally avoided a provider interface here.
 * Each provider has unique auth flows and response structures,
 * and wrapping them in a generic interface would require lossy abstraction.
 */
public class PaymentService {

    // Stripe configuration
    private static final String STRIPE_API_KEY   = "sk_live_xxxxxxxxxxxxxxxxxxxx";
    private static final String STRIPE_ENDPOINT  = "https://api.stripe.com/v1/charges";

    // PayPal configuration
    private static final String PAYPAL_CLIENT_ID = "AaXxXxXxXxXxXxXxXxXxXxXx";
    private static final String PAYPAL_SECRET    = "ELxXxXxXxXxXxXxXxXxXxXxX";
    private static final String PAYPAL_ENDPOINT  = "https://api.paypal.com/v2/checkout/orders";

    // CoinGate configuration
    private static final String COINGATE_KEY     = "coingate_live_xxxxxxxxxxxxxxxx";
    private static final String COINGATE_ENDPOINT = "https://api.coingate.com/v2/orders";

    /**
     * Processes a payment for the given order.
     * Routes to the correct payment provider based on order.getPaymentMethod().
     *
     * @return a Payment record with the transaction details
     */
    public Payment processPayment(Order order, double amount) {
        String txId = "TXN-" + UUID.randomUUID().toString().substring(0, 10).toUpperCase();
        String method = order.getPaymentMethod();
        String status = "FAILED";

        if ("CREDIT_CARD".equals(method)) {
            System.out.println("[STRIPE] Connecting to: " + STRIPE_ENDPOINT);
            System.out.println("[STRIPE] API Key: " + STRIPE_API_KEY);
            System.out.println("[STRIPE] Charging $" + String.format("%.2f", amount)
                    + " for order: " + order.getId());
            // Simulate successful charge
            status = "SUCCESS";
            System.out.println("[STRIPE] Transaction ID: " + txId + " — SUCCESS");

        } else if ("PAYPAL".equals(method)) {
            System.out.println("[PAYPAL] Connecting to: " + PAYPAL_ENDPOINT);
            System.out.println("[PAYPAL] Client ID: " + PAYPAL_CLIENT_ID);
            System.out.println("[PAYPAL] Initiating PayPal order for $" + String.format("%.2f", amount));
            // Simulate PayPal approval
            status = "SUCCESS";
            System.out.println("[PAYPAL] Payment captured: " + txId + " — SUCCESS");

        } else if ("CRYPTO".equals(method)) {
            System.out.println("[COINGATE] Connecting to: " + COINGATE_ENDPOINT);
            System.out.println("[COINGATE] API Key: " + COINGATE_KEY);
            System.out.println("[COINGATE] Creating crypto invoice for $" + String.format("%.2f", amount));
            // Crypto payments always take time
            status = "PENDING";
            System.out.println("[COINGATE] Invoice created: " + txId + " — PENDING blockchain confirmation");

        } else {
            throw new IllegalArgumentException("Unsupported payment method: " + method);
        }

        return new Payment(txId, order.getId(), amount, method, status);
    }

    /**
     * Issues a full refund for a given payment.
     * Must route back through the same provider used for the original charge.
     */
    public void refund(Payment payment) {
        String method = payment.getMethod();

        if ("CREDIT_CARD".equals(method)) {
            System.out.println("[STRIPE] Issuing full refund for transaction: " + payment.getTransactionId());
            System.out.println("[STRIPE] Refund of $" + String.format("%.2f", payment.getAmount()) + " initiated.");
        } else if ("PAYPAL".equals(method)) {
            System.out.println("[PAYPAL] Issuing refund for PayPal transaction: " + payment.getTransactionId());
        } else if ("CRYPTO".equals(method)) {
            // Crypto refunds are manual — we flag them for finance review
            System.out.println("[COINGATE] Crypto refund flagged for manual processing: " + payment.getTransactionId());
        }

        payment.setStatus("REFUNDED");
    }
}
