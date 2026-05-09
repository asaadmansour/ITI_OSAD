package com.company.ecommerce.repository;

import com.company.ecommerce.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Data access layer for orders.
 */
public class OrderRepository {

    private Map<String, Order> store = new HashMap<>();

    public void save(Order order) {
        store.put(order.getId(), order);
    }

    public Order findById(String id) {
        return store.get(id);
    }

    public List<Order> findByCustomerId(String customerId) {
        return store.values().stream()
                .filter(o -> o.getCustomer().getId().equals(customerId))
                .collect(Collectors.toList());
    }

    public List<Order> findAll() {
        return new ArrayList<>(store.values());
    }

    public int count() { return store.size(); }
}
