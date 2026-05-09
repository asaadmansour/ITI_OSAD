# ECommerce Console Application

A Java console-based e-commerce application implementing the Menu design pattern with Singleton services.

---

## 📁 Project Structure

```
ECommerce/
├── Main.java                    # Application entry point
├── context/
│   └── ApplicationContext.java  # Singleton - holds session state
├── menu/
│   ├── Menu.java                # Interface for all menus
│   └── Impl/
│       ├── MainMenu.java        # Navigation hub
│       ├── SignUpMenu.java      # User registration
│       ├── SignInMenu.java      # User authentication
│       ├── SignOutMenu.java     # Logout functionality
│       ├── ProductsMenu.java    # Product catalog & cart
│       ├── CheckOutMenu.java    # Order placement
│       ├── OrdersMenu.java      # View user orders
│       ├── SettingsMenu.java    # Settings navigation
│       ├── ChangePasswordMenu.java
│       ├── ChangeEmailMenu.java
│       └── CustomerListMenu.java # View all users
├── model/
│   ├── userModel/
│   │   ├── User.java            # Interface
│   │   └── UserImp.java         # Implementation
│   ├── productModel/
│   │   ├── Product.java         # Interface
│   │   └── ProductImp.java      # Implementation
│   ├── orderModel/
│   │   ├── Order.java           # Interface
│   │   └── OrderImp.java        # Implementation
│   └── cartModel/
│       ├── Cart.java            # Interface
│       └── CartImp.java         # Implementation
└── service/
    ├── UserManagementService.java     # Interface
    ├── UserManagementServiceImp.java  # Singleton - user CRUD
    ├── ProductManagementService.java  # Interface
    ├── ProductManagementServiceImp.java # Singleton - product data
    ├── OrderManagementService.java    # Interface
    └── OrderManagementServiceImp.java # Singleton - order CRUD
```

---

## 🏛️ Architecture

### Design Patterns Used

| Pattern | Where Used | Purpose |
|---------|-----------|---------|
| **Singleton** | All Services, ApplicationContext | Single instance, shared state |
| **Interface Segregation** | Menu, User, Product, Order, Cart | Decoupled contracts |
| **Menu Pattern** | All menu classes | Navigation flow |

### Application Flow

```
┌─────────────────────────────────────────────────────────────┐
│                         Main.java                           │
│                    MainMenu.start()                         │
└─────────────────────────┬───────────────────────────────────┘
                          │
                          ▼
┌─────────────────────────────────────────────────────────────┐
│                       MainMenu                              │
│  ┌─────────────────────────────────────────────────────┐   │
│  │ 1. Sign Up      → SignUpMenu                        │   │
│  │ 2. Sign In/Out  → SignInMenu / SignOutMenu          │   │
│  │ 3. Products     → ProductsMenu → CheckOutMenu       │   │
│  │ 4. My Orders    → OrdersMenu                        │   │
│  │ 5. Settings     → SettingsMenu → Change Email/Pass  │   │
│  │ 6. Customers    → CustomerListMenu                  │   │
│  └─────────────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────────────┘
```

---

## 🔧 Core Components

### ApplicationContext (Session State)
Holds the current session data:
- `loggedInUser` - Currently authenticated user
- `mainMenu` - Reference to main menu
- `sessionCart` - Shopping cart for current session

### Services (Business Logic)
All services use Singleton pattern with `getInstance()`:

| Service | Responsibilities |
|---------|-----------------|
| `UserManagementService` | Register, authenticate, retrieve users |
| `ProductManagementService` | Get products by ID or all products |
| `OrderManagementService` | Create orders, get orders by user |

### Models (Data Objects)
Each model has an **Interface** and **Implementation**:
- **User**: firstName, lastName, email, password, id
- **Product**: id, productName, category, price
- **Order**: customerId, creditCardNumber, products[]
- **Cart**: products[], addProduct(), clear(), isEmpty()

---

## 🚀 How to Run

```bash
# Compile
javac -d out $(find . -name "*.java")

# Run
java -cp out Main

# Exit the app
Type "exit" at main menu prompt
```

---

## 📋 Features

- ✅ User registration with auto-login
- ✅ Sign in / Sign out
- ✅ Browse product catalog
- ✅ Add products to cart
- ✅ Checkout with credit card validation
- ✅ View order history
- ✅ Change email/password
- ✅ View all registered customers

---

## 🔐 Credit Card Validation

Uses 16-digit validation:
- Must be exactly 16 digits
- No spaces allowed
- Must be a positive number

---

## 💡 Key Design Decisions

1. **Menu returns to MainMenu**: Each submenu returns to main menu after completion
2. **Singleton Services**: Ensures consistent data across the app
3. **Session Cart**: Cart persists until checkout or user logout
4. **No Scanner closing**: Closing `System.in` scanner would prevent further input
