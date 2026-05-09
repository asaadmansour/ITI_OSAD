# 🔀 Product Sorting (Comparator vs Comparable)

A Java project demonstrating the difference between **Comparator** and **Comparable** interfaces for custom sorting.

---

## 📋 Overview

This project shows how to implement custom sorting logic using the `Comparator` interface with method chaining to sort products by multiple criteria.

## 🏗️ Architecture

```
Product (Interface)
    └── ProductImp (Implementation)

CustomProductCompartor implements Comparator<Product>
    ├── Primary Sort: Category Name
    └── Secondary Sort: Price
```

## 📁 Files

| File | Description |
|------|-------------|
| `Product.java` | Interface defining product contract |
| `ProductImp.java` | Implementation with id, name, category, price |
| `CustomProductCompartor.java` | Custom comparator with multi-level sorting |

## 🔑 Key Concepts Demonstrated

### Comparator with Method Chaining
```java
public int compare(Product p1, Product p2) {
    return Comparator
            .comparing(Product::getCategoryName)
            .thenComparing(Product::getPrice)
            .compare(p1, p2);
}
```

### Traditional Approach (Commented)
```java
int result = p1.getCategoryName().compareTo(p2.getCategoryName());
if (result != 0)
    return result;
else 
    return Double.compare(p1.getPrice(), p2.getPrice());
```

## 📊 Comparator vs Comparable

| Feature | Comparable | Comparator |
|---------|------------|------------|
| Package | `java.lang` | `java.util` |
| Method | `compareTo(T o)` | `compare(T o1, T o2)` |
| Location | Inside the class | External class |
| Sorting | Single natural ordering | Multiple orderings |

## ▶️ How to Run

```bash
# Compile
javac *.java

# Run (create a main class to test)
java Main
```
