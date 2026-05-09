package com.company.orders;

public class Main {
    public static void main(String[] args) {
        OrderService service = new OrderService();

        // Set up products
        Product laptop = new Product("SKU-001", "ProBook Laptop 15\"", 899.99, "ELECTRONICS", 50);
        Product mouse  = new Product("SKU-002", "Wireless Mouse",       29.99, "ELECTRONICS", 200);
        Product novel  = new Product("SKU-003", "The Phoenix Project",  14.99, "BOOKS",       100);

        // Gold customer ordering electronics — should get tier + electronics discounts
        Customer goldCustomer = new Customer(
                "CUST-001", "Diana Prince", "diana@example.com",
                "GOLD", "12 Main St, Metropolis, NY 10001");

        Order order1 = new Order(service.generateOrderId(), goldCustomer);
        order1.addItem(laptop, 1);
        order1.addItem(mouse, 2);

        System.out.println("=== Placing Order 1 (Gold Customer, Electronics) ===");
        double charged1 = service.placeOrder(order1);
        System.out.printf("Final charged amount: $%.2f%n%n", charged1);

        // Standard customer ordering books — no discounts apply
        Customer standardCustomer = new Customer(
                "CUST-002", "Peter Parker", "peter@example.com",
                "STANDARD", "20 Ingram St, Queens, NY 11375");

        Order order2 = new Order(service.generateOrderId(), standardCustomer);
        order2.addItem(novel, 3);

        System.out.println("=== Placing Order 2 (Standard Customer, Books) ===");
        double charged2 = service.placeOrder(order2);
        System.out.printf("Final charged amount: $%.2f%n%n", charged2);

        // Try to cancel order1
        System.out.println("=== Cancelling Order 1 ===");
        service.cancelOrder(order1.getOrderId());
    }
}
