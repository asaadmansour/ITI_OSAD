package com.company.orders;

/**
 * Represents a customer of the business.
 */
public class Customer {
    private String id;
    private String name;
    private String email;
    private String tier; // "STANDARD", "SILVER", "GOLD", "PLATINUM"
    private String shippingAddress;

    public Customer(String id, String name, String email, String tier, String shippingAddress) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tier = tier;
        this.shippingAddress = shippingAddress;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getTier() { return tier; }
    public String getShippingAddress() { return shippingAddress; }
}
