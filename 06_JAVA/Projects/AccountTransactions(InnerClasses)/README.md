# 🏦 Account Transactions (Inner Classes)

A Java project demonstrating **inner classes** through a bank account transaction system.

---

## 📋 Overview

This project showcases how to use **static inner classes** to encapsulate related functionality. An `Account` can send/receive money and track all transactions using a nested `Transaction` class.

## 🏗️ Architecture

```
Account (Outer Class)
├── Transaction (Static Inner Class)
│   ├── accountFrom
│   ├── accountTo
│   ├── moneyAmount
│   └── operation
└── StandardAccountOperations (Enum)
    ├── MONEY_TRANSFER_SEND
    ├── MONEY_TRANSFER_RECEIVE
    └── WITHDRAW
```

## 📁 Files

| File | Description |
|------|-------------|
| `Account.java` | Main class with nested `Transaction` static inner class |
| `StandardAccountOperations.java` | Enum defining operation types |
| `Main.java` | Entry point for testing |

## 🔑 Key Concepts Demonstrated

### Static Inner Class
```java
public static class Transaction {
    private Account accountFrom;
    private Account accountTo;
    private double moneyAmount;
    private StandardAccountOperations operation;
}
```

### Dynamic Array Expansion
Uses `Arrays.copyOf()` with bit-shifting for efficient capacity doubling:
```java
transactions = Arrays.copyOf(transactions, transactions.length << 1);
```

## 💡 Features

- **Send Money**: Transfer funds between accounts
- **Receive Money**: Automatically logged when receiving transfers
- **Withdraw**: Record withdrawal transactions
- **Transaction History**: Filter and retrieve non-null transactions

## ▶️ How to Run

```bash
# Compile
javac *.java

# Run
java Main
```
