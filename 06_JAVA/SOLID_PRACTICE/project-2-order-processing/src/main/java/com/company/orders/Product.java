package com.company.orders;

/**
 * Represents a product available for purchase.
 */
public class Product {
    private String sku;
    private String name;
    private double unitPrice;
    private String category; // "ELECTRONICS", "CLOTHING", "BOOKS", "FOOD"
    private int stockQuantity;

    public Product(String sku, String name, double unitPrice, String category, int stockQuantity) {
        this.sku = sku;
        this.name = name;
        this.unitPrice = unitPrice;
        this.category = category;
        this.stockQuantity = stockQuantity;
    }

    public String getSku() { return sku; }
    public String getName() { return name; }
    public double getUnitPrice() { return unitPrice; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int qty) { this.stockQuantity = qty; }
}
