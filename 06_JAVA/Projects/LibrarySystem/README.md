# 📚 Library Management System

A Java console application for managing library items and client borrowing operations, built with a clean layered architecture.

## ✨ Features

- Add, view, update, and delete library items (Books & Magazines)
- Manage clients and their borrowing records
- Borrow and return items with stock management
- Input validation with user-friendly error messages

## 🏗️ Architecture

```
┌─────────────┐     ┌─────────────┐     ┌─────────────┐     ┌─────────────┐
│    View     │ ──▶ │ Controller  │ ──▶ │   Service   │ ──▶ │    Model    │
│   (Menus)   │     │    (I/O)    │     │(Orchestrate)│     │  (Domain)   │
└─────────────┘     └─────────────┘     └─────────────┘     └─────────────┘
```

| Layer | Does | Doesn't Do |
|-------|------|------------|
| **Model** | Business rules, state management | I/O, UI |
| **Service** | Coordinates between models | Console I/O |
| **Controller** | User input/output, error handling | Business logic |
| **View** | Display menus | Anything else |

## 🎯 Design Patterns Used

- **Factory Pattern** — `LibraryItemFactory` creates Books/Magazines without exposing concrete classes
- **Dependency Injection** — Services and controllers receive dependencies via constructor
- **MVC** — Clean separation of concerns

## 🚀 Quick Start

```bash
# Compile
javac -d out $(find . -name "*.java")

# Run
java -cp out Main
```

## 📁 Structure

```
src/
├── Main.java              # Entry point
├── model/                 # Domain entities with behavior
│   ├── Client.java        # borrowItem(), returnItem()
│   ├── LibraryItem.java   # isAvailable(), decrementStock()
│   └── Library.java       # findById(), findByIdOrThrow()
├── service/               # Pure orchestration (no I/O)
├── controller/            # All user I/O lives here
├── view/                  # Menu displays
└── Util/                  # Input validation helpers
```

## 💡 Key Takeaways

1. **Tell, Don't Ask** — Objects do things, don't just hold data
2. **Encapsulation** — No `setStock()`, use `decrementStock()` instead
3. **Single Responsibility** — Each class has one reason to change
4. **Services ≠ God Classes** — They orchestrate, not implement
