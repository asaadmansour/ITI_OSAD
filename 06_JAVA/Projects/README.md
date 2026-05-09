# 📦 Java Projects

A collection of Java projects demonstrating core OOP concepts and design patterns developed during ITI OSAD training.

---

## 🗂️ Projects Overview

| Project | Concept Focus | Description |
|---------|---------------|-------------|
| [AccountTransactions](./AccountTransactions(InnerClasses)) | Inner Classes | Bank account system with nested Transaction class |
| [ECommerce](./ECommerce) | Full Application | Complete e-commerce console app with MVC architecture |
| [LibrarySystem](./LibrarySystem) | OOP Principles | Library management with services and repositories |
| [ProductSorting](./ProductSorting(CompartorVsComprable)) | Comparator vs Comparable | Custom sorting with method chaining |
| [StudentGradesSystem](./StudentGradesSystem) | Generics & Inner Classes | Grade tracking with menu-driven interface |
| [SweetsInheritence](./SweetsInheritence) | Inheritance & Abstract | Gift box with polymorphic sweets collection |

---

## 🎯 Concepts Covered

### OOP Fundamentals
- **Inheritance** - `SweetsInheritence`
- **Abstract Classes** - `SweetsInheritence`
- **Interfaces** - `ProductSorting`, `StudentGradesSystem`
- **Encapsulation** - All projects

### Advanced Java
- **Inner Classes** - `AccountTransactions`, `StudentGradesSystem`
- **Generics** - `StudentGradesSystem`
- **Enums** - `AccountTransactions`, `ECommerce`
- **Comparator/Comparable** - `ProductSorting`

### Design Patterns
- **MVC Architecture** - `ECommerce`
- **Service Layer** - `LibrarySystem`, `ECommerce`
- **Repository Pattern** - `ECommerce`

---

## 🚀 Quick Start

Each project can be compiled and run independently:

```bash
# Navigate to any project folder
cd ProjectName

# Compile all Java files
javac *.java

# Run the main class
java Main  # or Demo, depending on the project
```

---

## 📚 Project Details

### 🏦 AccountTransactions (Inner Classes)
Demonstrates **static inner classes** with a banking transaction system:
- Send/receive money between accounts
- Transaction history tracking
- Dynamic array expansion

### 🛒 ECommerce
Full-featured console e-commerce application:
- User authentication
- Product browsing and cart management
- Order processing with payment simulation

### 📖 LibrarySystem
Library management with proper separation of concerns:
- Book and user management
- Borrowing/returning logic
- File persistence

### 🔀 ProductSorting
Shows **Comparator vs Comparable**:
- Multi-level sorting (category, then price)
- Method chaining with `Comparator.comparing().thenComparing()`

### 🎓 StudentGradesSystem
Menu-driven grade tracker:
- Generic utility methods
- Private inner class for registrations
- Duplicate ID validation

### 🍬 SweetsInheritence
Inheritance and polymorphism demo:
- Abstract base class
- Gift container with filtering
- Stream API alternatives (commented)
