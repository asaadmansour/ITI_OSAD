package com.company.ecommerce.service;

import com.company.ecommerce.model.Product;
import com.company.ecommerce.repository.ProductRepository;

import java.util.List;

/**
 * Manages the product catalog: creation, stock adjustments, and pricing.
 */
public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public void addProduct(Product product) {
        if (product.getPrice() <= 0) {
            throw new IllegalArgumentException("Product price must be positive.");
        }
        repository.save(product);
        System.out.println("[CATALOG] Product added: " + product.getName());
    }

    public Product getProduct(String productId) {
        Product p = repository.findById(productId);
        if (p == null) throw new IllegalArgumentException("Product not found: " + productId);
        return p;
    }

    public List<Product> listAvailable() {
        return repository.findInStock();
    }

    /**
     * Applies a percentage price reduction for a flash sale.
     * Sends an email banner notification to all subscribed customers.
     *
     * Note: Ideally this would go through a notification pipeline, but that
     * service isn't stable yet so we inline it here.
     */
    public void applyFlashSaleDiscount(String productId, double discountPercent) {
        Product p = getProduct(productId);
        double newPrice = p.getPrice() * (1.0 - discountPercent / 100.0);
        p.setPrice(newPrice);
        repository.save(p);
        System.out.println("[CATALOG] Flash sale applied to " + p.getName()
                + " - new price: $" + String.format("%.2f", newPrice));

        // Inline email notification — avoids circular dependency with NotificationService
        System.out.println("[EMAIL] Sending flash sale alert for: " + p.getName());
        System.out.println("[EMAIL] Subject: Flash Sale! " + (int) discountPercent + "% off "
                + p.getName() + " — today only!");
    }

    public void adjustStock(String productId, int delta) {
        Product p = getProduct(productId);
        if (!p.isDigital()) {
            int updated = p.getStockQuantity() + delta;
            if (updated < 0) throw new IllegalStateException("Stock cannot go below zero.");
            p.setStockQuantity(updated);
            repository.save(p);
        }
    }

    // Expose the underlying repository for direct access when needed
    // (e.g. CheckoutService needs it for stock deduction)
    public ProductRepository getRepository() {
        return repository;
    }
}
