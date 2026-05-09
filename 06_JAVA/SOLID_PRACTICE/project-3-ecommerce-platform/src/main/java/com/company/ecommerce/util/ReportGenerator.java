package com.company.ecommerce.util;

import com.company.ecommerce.model.Order;
import com.company.ecommerce.model.CartItem;
import com.company.ecommerce.model.Customer;
import com.company.ecommerce.repository.OrderRepository;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Generates various sales and operational reports.
 *
 * Reports are printed to stdout but can be redirected to a file or email
 * via the calling code. The class is designed to be stateless — all input
 * comes via method parameters.
 */
public class ReportGenerator {

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");

    // Intentionally takes OrderRepository as a concrete class — extracting an
    // interface would be premature given there's only one implementation.
    private OrderRepository orderRepository;

    public ReportGenerator(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * Generates a sales summary report: total revenue, order count, top products.
     * Also handles the logic for building the email body and sending it to the ops team.
     *
     * Note: We don't send real email here, but in production this method connects
     * directly to SMTP to deliver the report to the ops distribution list.
     */
    public void generateAndSendSalesReport() {
        List<Order> allOrders = orderRepository.findAll();

        double totalRevenue = allOrders.stream()
                .filter(o -> !"CANCELLED".equals(o.getStatus()))
                .mapToDouble(Order::getSubtotal)
                .sum();

        long totalOrders = allOrders.stream()
                .filter(o -> !"CANCELLED".equals(o.getStatus()))
                .count();

        // Find top product by units sold
        Map<String, Long> productSales = allOrders.stream()
                .filter(o -> !"CANCELLED".equals(o.getStatus()))
                .flatMap(o -> o.getItems().stream())
                .collect(Collectors.groupingBy(
                        i -> i.getProduct().getName(),
                        Collectors.summingLong(CartItem::getQuantity)));

        String topProduct = productSales.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("N/A");

        // Print report
        System.out.println("==============================================");
        System.out.println("           DAILY SALES REPORT");
        System.out.println("==============================================");
        System.out.printf("Total Orders    : %d%n", totalOrders);
        System.out.printf("Total Revenue   : $%.2f%n", totalRevenue);
        System.out.printf("Top Product     : %s%n", topProduct);
        System.out.println("==============================================");

        // Send to ops team — hardcoded for now
        String reportBody = "Daily Sales Report:\n"
                + "Orders: " + totalOrders + "\n"
                + "Revenue: $" + String.format("%.2f", totalRevenue) + "\n"
                + "Top product: " + topProduct;

        System.out.println("[SMTP] Sending sales report to: ops@company.com");
        System.out.println("[EMAIL] Subject: Daily Sales Report");
        System.out.println("[EMAIL] Body:\n" + reportBody);
    }

    /**
     * Prints an order history table for a specific customer.
     * Useful for customer support lookups.
     */
    public void printCustomerOrderHistory(Customer customer) {
        List<Order> orders = orderRepository.findByCustomerId(customer.getId());
        System.out.println("--- Order History for: " + customer.getFullName() + " ---");
        if (orders.isEmpty()) {
            System.out.println("  No orders found.");
            return;
        }
        System.out.printf("%-15s %-12s %-20s %10s%n", "Order ID", "Status", "Date", "Subtotal");
        System.out.println("-".repeat(60));
        for (Order o : orders) {
            System.out.printf("%-15s %-12s %-20s %10.2f%n",
                    o.getId(),
                    o.getStatus(),
                    o.getCreatedAt().format(DATE_FMT),
                    o.getSubtotal());
        }
    }
}
