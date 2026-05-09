package com.company.ecommerce;

import com.company.ecommerce.model.*;
import com.company.ecommerce.repository.OrderRepository;
import com.company.ecommerce.service.CheckoutService;
import com.company.ecommerce.service.ProductService;
import com.company.ecommerce.util.ReportGenerator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // ─── Setup Catalog ───────────────────────────────────────────────
        ProductService productService = new ProductService();

        Product macbook = new Product("P001", "MacBook Pro 14\"",
                "Apple M3 Pro, 18GB RAM, 512GB SSD", 1999.99, "ELECTRONICS", 30, false);
        Product jeans   = new Product("P002", "Slim Fit Jeans",
                "Premium denim, available in multiple sizes", 79.99, "CLOTHING", 150, false);
        Product ebook   = new Product("P003", "Clean Code (eBook)",
                "Digital edition by Robert C. Martin", 19.99, "BOOKS", 0, true);

        productService.addProduct(macbook);
        productService.addProduct(jeans);
        productService.addProduct(ebook);

        // ─── Apply Flash Sale ─────────────────────────────────────────────
        System.out.println("\n=== Applying flash sale on jeans ===");
        productService.applyFlashSaleDiscount("P002", 25.0);

        // ─── Customers ───────────────────────────────────────────────────
        Customer vipCustomer = new Customer(
                "C001", "Natasha Romanoff", "natasha@shield.gov", "+12025551234",
                "VIP", "S.H.I.E.L.D HQ, NY", "Avengers Tower, NY 10001", 1500.0);

        Customer basicCustomer = new Customer(
                "C002", "Peter Parker", "peter@dailybugle.com", "+12125559876",
                "BASIC", "20 Ingram St, Queens", "20 Ingram St, Queens, NY 11375", 0.0);

        // ─── Checkout 1: VIP customer buying electronics + ebook ──────────
        CheckoutService checkoutService = new CheckoutService();

        List<CartItem> vipCart = Arrays.asList(
                new CartItem(macbook, 1),
                new CartItem(ebook, 1)
        );

        System.out.println("\n=== VIP Customer Checkout ===");
        Order vipOrder = checkoutService.checkout(
                vipCustomer, vipCart, "CREDIT_CARD", "Avengers Tower, NY 10001");
        System.out.println("Order placed: " + vipOrder.getId() + " | Status: " + vipOrder.getStatus());

        // ─── Checkout 2: Basic customer buying clothing (PayPal) ──────────
        List<CartItem> basicCart = Arrays.asList(
                new CartItem(jeans, 2)
        );

        System.out.println("\n=== Basic Customer Checkout (PayPal) ===");
        Order basicOrder = checkoutService.checkout(
                basicCustomer, basicCart, "PAYPAL", "20 Ingram St, Queens, NY 11375");
        System.out.println("Order placed: " + basicOrder.getId() + " | Status: " + basicOrder.getStatus());

        // ─── Return: VIP customer returns their order ─────────────────────
        System.out.println("\n=== VIP Customer Return ===");
        // Change status to simulate delivered
        vipOrder.setStatus("DELIVERED");
        checkoutService.processReturn(vipOrder.getId(), vipCustomer);

        // ─── Reports ──────────────────────────────────────────────────────
        System.out.println("\n=== Sales Report ===");
        // NOTE: ReportGenerator has its own private OrderRepository — different instance!
        // This means the report won't reflect the orders placed above (a subtle bug from
        // poor DI design). In production you'd fix this by sharing the repository instance.
        OrderRepository sharedRepository = new OrderRepository();
        ReportGenerator reporter = new ReportGenerator(sharedRepository);
        reporter.generateAndSendSalesReport();

        System.out.println("\n=== Customer Order History ===");
        reporter.printCustomerOrderHistory(vipCustomer);
    }
}
