# E-Commerce Platform

A multi-layer e-commerce backend built to support an online store with product catalog,
shopping cart, checkout, payment processing, and order fulfillment.

## What it does
- Manages a product catalog with stock tracking
- Handles customer shopping carts and checkout flows
- Integrates with a payment gateway (Stripe-like) and a shipping provider (FedEx-like)
- Generates sales reports and sends transactional emails
- Supports order tracking and status updates

## Architecture
```
model/       → Domain entities
repository/  → Data access layer (simulated JDBC)
service/     → Business logic
util/        → Cross-cutting helpers
Main.java    → Entry point / wiring
```

## Running
Compile all `.java` files under `src/main/java/` and run `Main.java`.
