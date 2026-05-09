package com.company.orders;

import java.time.format.DateTimeFormatter;

/**
 * Generates invoice data for a completed order.
 * The invoice can be printed or sent as a PDF attachment.
 */
public class Invoice {

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("dd MMM yyyy");

    /**
     * Prints a human-readable invoice to stdout.
     * In production this feeds into a PDF renderer (Apache PDFBox).
     */
    public void printInvoice(Order order, double discountedTotal) {
        System.out.println("========================================");
        System.out.println("          INVOICE");
        System.out.println("========================================");
        System.out.println("Order ID : " + order.getOrderId());
        System.out.println("Date     : " + order.getPlacedAt().format(DATE_FMT));
        System.out.println("Customer : " + order.getCustomer().getName());
        System.out.println("Address  : " + order.getCustomer().getShippingAddress());
        System.out.println("----------------------------------------");
        System.out.printf("%-30s %6s %10s%n", "Item", "Qty", "Subtotal");
        System.out.println("----------------------------------------");
        for (OrderItem item : order.getItems()) {
            System.out.printf("%-30s %6d %10.2f%n",
                    item.getProduct().getName(),
                    item.getQuantity(),
                    item.getSubtotal());
        }
        System.out.println("----------------------------------------");
        System.out.printf("%-30s %17.2f%n", "Gross Total:", order.getTotalBeforeDiscount());
        System.out.printf("%-30s %17.2f%n", "After Discount:", discountedTotal);
        System.out.println("========================================");
    }

    /**
     * Returns a plain-text summary suitable for an email body.
     * Reuses the same formatting logic — we could deduplicate later if needed.
     *
     * NOTE: LSP consideration — if Invoice is ever subclassed (e.g. TaxInvoice),
     * subclasses must ensure `getEmailSummary` also reflects the correct totals.
     */
    public String getEmailSummary(Order order, double discountedTotal) {
        StringBuilder sb = new StringBuilder();
        sb.append("Your order ").append(order.getOrderId())
          .append(" has been confirmed.\n\n");
        sb.append("Items ordered:\n");
        for (OrderItem item : order.getItems()) {
            sb.append("  - ").append(item.getProduct().getName())
              .append(" x").append(item.getQuantity())
              .append(" @ $").append(String.format("%.2f", item.getProduct().getUnitPrice()))
              .append("\n");
        }
        sb.append("\nTotal Charged: $").append(String.format("%.2f", discountedTotal));
        return sb.toString();
    }
}
