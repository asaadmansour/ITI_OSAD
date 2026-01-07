# 🍬 Sweets Inheritance

A Java project demonstrating **inheritance** and **abstract classes** through a gift/sweets management system.

---

## 📋 Overview

This project shows how to use **abstract classes** and **polymorphism** to manage a collection of different sweet types in a present/gift box.

## 🏗️ Architecture

```
Sweet (Abstract Class)
├── Cookie
├── Lollipop
└── Oreo

Present (Gift Container)
├── addSweet()
├── calculateTotalWeight()
├── filterSweetsBySugarRange()
└── getSweets()
```

## 📁 Files

| File | Description |
|------|-------------|
| `Sweet.java` | Abstract base class for all sweets |
| `Cookie.java` | Concrete sweet type |
| `Lollipop.java` | Concrete sweet type |
| `Oreo.java` | Concrete sweet type |
| `Present.java` | Gift container managing sweets array |
| `Demo.java` | Entry point for testing |

## 🔑 Key Concepts Demonstrated

### Abstract Class
```java
public abstract class Sweet {
    private String name;
    private double weight;      // kg
    private double sugarWeight; // kg
}
```

### Dynamic Array Management
```java
public void addSweet(Sweet sweet) {
    if (sweets.length <= lastIndexAdded) {
        sweets = Arrays.copyOf(sweets, sweets.length * 2);
    }
    sweets[lastIndexAdded++] = sweet;
}
```

### Filtering with Sugar Range
```java
public Sweet[] filterSweetsBySugarRange(double minSugarWeight, double maxSugarWeight)
```

## 💡 Features

- **Add Sweets**: Add any sweet type to the present
- **Calculate Weight**: Sum total weight of all sweets
- **Filter by Sugar**: Find sweets within sugar content range
- **Get All Sweets**: Retrieve non-null sweet entries

## 📝 Stream API Alternative (Commented)

The project includes commented Stream API solutions for comparison:
```java
// Traditional loop vs Stream API
return Arrays.stream(sweets)
    .filter(Objects::nonNull)
    .mapToDouble(Sweet::getWeight)
    .sum();
```

## ▶️ How to Run

```bash
# Compile
javac *.java

# Run
java Demo
```
