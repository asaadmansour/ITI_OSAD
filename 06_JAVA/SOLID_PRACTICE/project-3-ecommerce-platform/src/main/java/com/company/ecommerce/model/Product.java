package com.company.ecommerce.model;

/**
 * A product in the catalog. Supports both physical and digital goods.
 */
public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private String category;
    private int stockQuantity;
    private boolean digital; // digital products have no stock limit

    public Product(String id, String name, String description, double price,
                   String category, int stockQuantity, boolean digital) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        this.digital = digital;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int qty) { this.stockQuantity = qty; }
    public boolean isDigital() { return digital; }
}
