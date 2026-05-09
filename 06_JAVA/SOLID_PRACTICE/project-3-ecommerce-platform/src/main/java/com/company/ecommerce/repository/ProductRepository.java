package com.company.ecommerce.repository;

import com.company.ecommerce.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Data access layer for products.
 * Backed by an in-memory map; in production this uses a JDBC connection pool.
 */
public class ProductRepository {

    private Map<String, Product> store = new HashMap<>();

    public void save(Product product) {
        store.put(product.getId(), product);
    }

    public Product findById(String id) {
        return store.get(id);
    }

    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }

    public List<Product> findByCategory(String category) {
        return store.values().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Product> findInStock() {
        return store.values().stream()
                .filter(p -> p.isDigital() || p.getStockQuantity() > 0)
                .collect(Collectors.toList());
    }

    public int count() { return store.size(); }
}
