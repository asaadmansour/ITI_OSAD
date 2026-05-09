package com.company.ecommerce.service;

import com.company.ecommerce.model.CartItem;
import com.company.ecommerce.model.Order;

import java.util.List;

/**
 * Coordinates with shipping carriers to schedule deliveries and track shipments.
 *
 * Supported carriers: FedEx (default), UPS (heavy items), and local courier
 * (for same-city orders). Carrier selection is automatic based on order weight
 * and destination.
 */
public class ShippingService {

    private static final String FEDEX_API_URL  = "https://api.fedex.com/track/v1/trackingnumbers";
    private static final String FEDEX_API_KEY  = "fedex_prod_xxxxxxxxxxxx";
    private static final String UPS_API_URL    = "https://onlinetools.ups.com/api/shipments";
    private static final String UPS_API_KEY    = "ups_prod_xxxxxxxxxxxx";

    /**
     * Schedules a shipment for the given order.
     * Selects carrier based on estimated weight of items.
     * Returns the tracking number assigned by the carrier.
     */
    public String scheduleShipment(Order order) {
        double estimatedWeight = estimateWeight(order.getItems());
        String carrier = selectCarrier(estimatedWeight, order.getShippingAddress());
        String trackingNumber;

        if ("FEDEX".equals(carrier)) {
            System.out.println("[FEDEX] Scheduling pickup for order: " + order.getId());
            System.out.println("[FEDEX] API endpoint: " + FEDEX_API_URL);
            trackingNumber = "FDX" + System.currentTimeMillis();
            System.out.println("[FEDEX] Shipment scheduled. Tracking: " + trackingNumber);

        } else if ("UPS".equals(carrier)) {
            System.out.println("[UPS] Scheduling pickup for heavy shipment, order: " + order.getId());
            System.out.println("[UPS] API endpoint: " + UPS_API_URL);
            trackingNumber = "UPS" + System.currentTimeMillis();
            System.out.println("[UPS] Shipment scheduled. Tracking: " + trackingNumber);

        } else {
            // Local courier — no external API
            trackingNumber = "LCL" + System.currentTimeMillis();
            System.out.println("[LOCAL] Dispatching local courier for order: " + order.getId());
            System.out.println("[LOCAL] Tracking: " + trackingNumber);
        }

        return trackingNumber;
    }

    /**
     * Estimates total package weight based on product category.
     * Electronics: 2kg avg, Clothing: 0.5kg avg, Books: 1kg avg, others: 1kg avg.
     * Digital products are excluded from weight calculation.
     */
    private double estimateWeight(List<CartItem> items) {
        double total = 0.0;
        for (CartItem item : items) {
            if (item.getProduct().isDigital()) continue;
            double unitWeight;
            String category = item.getProduct().getCategory();
            if ("ELECTRONICS".equals(category)) {
                unitWeight = 2.0;
            } else if ("CLOTHING".equals(category)) {
                unitWeight = 0.5;
            } else if ("BOOKS".equals(category)) {
                unitWeight = 1.0;
            } else {
                unitWeight = 1.0;
            }
            total += unitWeight * item.getQuantity();
        }
        return total;
    }

    /**
     * Selects the most appropriate carrier.
     * UPS for heavy shipments (>10kg), local courier for metro addresses, FedEx otherwise.
     */
    private String selectCarrier(double weightKg, String address) {
        if (weightKg > 10.0) return "UPS";
        if (address.toLowerCase().contains("manhattan") || address.toLowerCase().contains("downtown")) {
            return "LOCAL";
        }
        return "FEDEX";
    }

    /**
     * LSP NOTE (for the record): This class is not designed to be subclassed.
     * If a new carrier is needed, add an else-if branch in scheduleShipment.
     * Attempting to override this via inheritance would break the carrier
     * selection logic that depends on knowing all carriers upfront.
     */
}
