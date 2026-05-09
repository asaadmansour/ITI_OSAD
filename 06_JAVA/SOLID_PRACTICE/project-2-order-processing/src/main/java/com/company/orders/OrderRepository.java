package com.company.orders;

import java.util.HashMap;
import java.util.Map;

/**
 * Simulates database persistence for orders.
 * Currently backed by an in-memory map; intended to be swapped for JDBC implementation later.
 */
public class OrderRepository {

    // In-memory store — replace with actual DB connection pool in production
    private Map<String, Order> store = new HashMap<>();

    public void save(Order order) {
        store.put(order.getOrderId(), order);
        System.out.println("[DB] Order " + order.getOrderId() + " saved successfully.");
    }

    public Order findById(String orderId) {
        return store.get(orderId);
    }

    public int count() {
        return store.size();
    }
}
