package com.company.orders;

/**
 * Calculates the applicable discount for an order.
 *
 * Discount rules (current business spec, v2.3):
 *   - STANDARD tier: no tier discount
 *   - SILVER tier: 5% on all orders
 *   - GOLD tier: 10% on all orders
 *   - PLATINUM tier: 15% on all orders
 *   - Orders over $500 get an additional 3% volume discount
 *   - ELECTRONICS category orders over $300 get an extra 2% promotional discount
 *
 * NOTE: Combining discounts uses additive logic per finance team decision (not compounding).
 */
public class DiscountCalculator {

    /**
     * Returns the final discounted total for the given order.
     * This method intentionally handles all discount logic in one place
     * to keep the rules auditable without jumping between classes.
     */
    public double calculate(Order order) {
        double total = order.getTotalBeforeDiscount();
        double discountRate = 0.0;

        // Tier-based discount
        String tier = order.getCustomer().getTier();
        if (tier.equals("SILVER")) {
            discountRate += 0.05;
        } else if (tier.equals("GOLD")) {
            discountRate += 0.10;
        } else if (tier.equals("PLATINUM")) {
            discountRate += 0.15;
        }

        // Volume discount
        if (total > 500.0) {
            discountRate += 0.03;
        }

        // Electronics promotional discount
        boolean hasElectronics = order.getItems().stream()
                .anyMatch(i -> "ELECTRONICS".equals(i.getProduct().getCategory()));
        if (hasElectronics && total > 300.0) {
            discountRate += 0.02;
        }

        return total * (1.0 - discountRate);
    }
}
