package com.company.notification;

/**
 * Represents a registered user in the system.
 */
public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private String preferredChannel; // "email" or "sms"

    public User(String name, String email, String phoneNumber, String preferredChannel) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.preferredChannel = preferredChannel;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getPreferredChannel() { return preferredChannel; }
}
