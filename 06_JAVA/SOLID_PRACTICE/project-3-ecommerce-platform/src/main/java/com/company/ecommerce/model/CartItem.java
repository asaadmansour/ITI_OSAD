package com.company.ecommerce.model;

/**
 * Represents one item in a shopping cart or order.
 */
public class CartItem {
    private Product product;
    private int quantity;
    private double unitPriceAtAddTime; // locked when added to cart

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.unitPriceAtAddTime = product.getPrice();
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getUnitPriceAtAddTime() { return unitPriceAtAddTime; }
    public double getLineTotal() { return unitPriceAtAddTime * quantity; }
}
