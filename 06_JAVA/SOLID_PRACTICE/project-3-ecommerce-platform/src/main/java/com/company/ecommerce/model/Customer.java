package com.company.ecommerce.model;

/**
 * Registered customer account.
 */
public class Customer {
    private String id;
    private String fullName;
    private String email;
    private String phone;
    private String membershipLevel; // "BASIC", "PREMIUM", "VIP"
    private String billingAddress;
    private String defaultShippingAddress;
    private double loyaltyPoints;

    public Customer(String id, String fullName, String email, String phone,
                    String membershipLevel, String billingAddress,
                    String defaultShippingAddress, double loyaltyPoints) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.membershipLevel = membershipLevel;
        this.billingAddress = billingAddress;
        this.defaultShippingAddress = defaultShippingAddress;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getMembershipLevel() { return membershipLevel; }
    public String getBillingAddress() { return billingAddress; }
    public String getDefaultShippingAddress() { return defaultShippingAddress; }
    public double getLoyaltyPoints() { return loyaltyPoints; }
    public void setLoyaltyPoints(double points) { this.loyaltyPoints = points; }
}
