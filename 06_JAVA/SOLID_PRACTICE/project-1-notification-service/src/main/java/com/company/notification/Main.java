package com.company.notification;

public class Main {
    public static void main(String[] args) {

    
        ChannelFactory channelFactory = new ChannelFactory();
        Logger         logger         = new Logger();
        NotificationManager manager   = new NotificationManager(channelFactory, logger);

        User alice = new User("Alice Johnson", "alice@example.com", "+15551234567", "email");
        User bob   = new User("Bob Smith",     "bob@example.com",   "+15559876543", "sms");

        System.out.println("=== Password Resets ===");
        manager.notify(alice, "password_reset");
        manager.notify(bob,   "password_reset");

        System.out.println("\n=== Promotions ===");
        manager.notify(alice, "promotion");
        manager.notify(bob,   "promotion");
    }
}
