# HelpDesk Priority Queue System

A Java application that demonstrates **priority-based ticket processing** using the `PriorityQueue` data structure and the **Facade Design Pattern**.

---

## 🎯 Project Overview

This system simulates a HelpDesk where support tickets are processed based on their **priority level**, not their arrival order. High-priority issues (like hacked accounts) are handled before low-priority ones (like general inquiries).

### Key Concepts

| Concept | Implementation |
|---------|----------------|
| **Natural Ordering** | `Comparable<SupportTicket>` interface |
| **Priority Processing** | `PriorityQueue` data structure |
| **Abstraction** | Facade Design Pattern |
| **Encapsulation** | Interface + Implementation separation |

---

## 🏗️ Architecture

```
┌─────────────────────────────────────────────────────────────────┐
│                          Main.java                               │
│                    (Client / Entry Point)                        │
└─────────────────────────────────────────────────────────────────┘
                                │
                                ▼
┌─────────────────────────────────────────────────────────────────┐
│                      HelpDeskFacade                              │
│                       (Interface)                                │
│  ┌───────────────────────────────────────────────────────────┐  │
│  │ + addNewSupportTicket(SupportTicket)                      │  │
│  │ + getNextSupportTicket() : SupportTicket                  │  │
│  │ + getNumberOfTickets() : int                              │  │
│  └───────────────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────────────┘
                                │
                                ▼
┌─────────────────────────────────────────────────────────────────┐
│                    HelpDeskFacadeImpl                            │
│              (Uses PriorityQueue internally)                     │
│  ┌───────────────────────────────────────────────────────────┐  │
│  │ - Queue<SupportTicket> line = new PriorityQueue<>()       │  │
│  └───────────────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────────────┘
                                │
                                ▼
┌─────────────────────────────────────────────────────────────────┐
│                       SupportTicket                              │
│          (Interface extends Comparable<SupportTicket>)           │
│  ┌───────────────────────────────────────────────────────────┐  │
│  │ + getPriority() : Priority                                │  │
│  │ + getSequentialNumber() : Integer                         │  │
│  │ + getRequestType() : RequestType                          │  │
│  │ + compareTo(SupportTicket) : int                          │  │
│  └───────────────────────────────────────────────────────────┘  │
└─────────────────────────────────────────────────────────────────┘
```

---

## 📁 File Structure

```
HelpDeskPriority(PriorityQueue)/
├── Main.java                          # Entry point & test
├── README.md                          # This file
│
├── facade/                            # Facade Layer
│   ├── HelpDeskFacade.java           # Interface (contract)
│   └── impl/
│       └── HelpDeskFacadeImpl.java   # Implementation (PriorityQueue)
│
└── model/                             # Domain Layer
    ├── Priority.java                  # Enum: HIGH, MEDIUM, LOW
    ├── RequestType.java               # Enum: ticket types with priorities
    ├── SupportTicket.java             # Interface (Comparable)
    └── impl/
        └── SupportTicketImpl.java     # Implementation with compareTo()
```

---

## 🎨 Design Patterns Used

### 1. Facade Pattern

The **Facade Pattern** provides a simplified interface to a complex subsystem.

```
┌──────────────┐         ┌─────────────────────────────────────┐
│    Client    │ ──────► │         HelpDeskFacade              │
│  (Main.java) │         │  (Hides PriorityQueue complexity)   │
└──────────────┘         └─────────────────────────────────────┘
                                        │
                         ┌──────────────┼──────────────┐
                         ▼              ▼              ▼
                  PriorityQueue   SupportTicket   Comparable
```

**Why use it?**
- Client doesn't need to know about `PriorityQueue`
- Easy to swap implementations (e.g., `Deque` instead)
- Clean, testable API

### 2. Strategy Pattern (via Comparable)

By implementing `Comparable`, the sorting strategy is embedded in the `SupportTicket` itself:

```java
@Override
public int compareTo(SupportTicket st) {
    int priorityCompare = this.getPriority().compareTo(st.getPriority());
    if (priorityCompare != 0) {
        return priorityCompare;
    }
    return this.getSequentialNumber().compareTo(st.getSequentialNumber());
}
```

---

## 🔄 How It Works (Flow)

### Step 1: Create Tickets
```java
SupportTicket ticket = new SupportTicketImpl(RequestType.ACCOUNT_IS_HACKED);
```
- Each `RequestType` has a predefined `Priority`
- Each ticket gets a unique `sequentialNumber` (auto-incremented)

### Step 2: Add to HelpDesk
```java
helpDesk.addNewSupportTicket(ticket);
```
- Internally calls `PriorityQueue.offer(ticket)`
- The `PriorityQueue` uses `compareTo()` to maintain order

### Step 3: Process Tickets
```java
SupportTicket next = helpDesk.getNextSupportTicket();
```
- Returns the **highest priority** ticket
- If same priority, returns the **earlier** ticket (FIFO within priority)

### Priority Ordering

```
Priority Enum:       HIGH(0) → MEDIUM(1) → LOW(2)
                        │
                        ▼
compareTo() result:  HIGH < MEDIUM < LOW  (natural ordering)
                        │
                        ▼
PriorityQueue:       Smallest first → HIGH tickets first!
```

---

## 💡 How to Think About This Design

### 1. Start with the Problem
> "I need a ticket system where urgent issues are handled first."

### 2. Identify Core Abstractions
- **Ticket**: What is being processed
- **Priority**: How to rank tickets
- **HelpDesk**: Where tickets go

### 3. Choose the Right Data Structure
| Need | Solution |
|------|----------|
| Auto-sorted by priority | `PriorityQueue` ✅ |
| Natural ordering | `Comparable` interface |

### 4. Apply Design Patterns
- **Facade**: Hide complexity from the client
- **Interface + Impl**: Easy to change/test

### 5. Separate Concerns
```
model/     → What things ARE (data)
facade/    → What things DO (behavior)
Main.java  → How to USE them (client)
```

---

## 🧪 Running the Project

```bash
# Compile all files
javac Main.java model/*.java model/impl/*.java facade/*.java facade/impl/*.java

# Run the test
java Main
```

### Expected Output

```
=== HelpDesk Priority Queue Test ===

Adding tickets in this order:
1. OTHER (LOW priority)
2. ACCOUNT_IS_HACKED (HIGH priority)
3. CAN_NOT_LOGIN (MEDIUM priority)
4. CAN_NOT_COMPLETE_PURCHASE (HIGH priority)
5. CHANGE_ACCOUNT_DETAILS (LOW priority)
6. ACCOUNT_IS_BLOCKED (MEDIUM priority)

Total tickets in queue: 6

=== Processing Tickets (Expected: HIGH -> MEDIUM -> LOW) ===

Processing Ticket #2: ACCOUNT_IS_HACKED (Priority: HIGH)
Processing Ticket #4: CAN_NOT_COMPLETE_PURCHASE (Priority: HIGH)
Processing Ticket #3: CAN_NOT_LOGIN (Priority: MEDIUM)
Processing Ticket #6: ACCOUNT_IS_BLOCKED (Priority: MEDIUM)
Processing Ticket #1: OTHER (Priority: LOW)
Processing Ticket #5: CHANGE_ACCOUNT_DETAILS (Priority: LOW)

All tickets processed! Queue size: 0
```

---

## 📌 Key Takeaways

1. **`Comparable` defines natural ordering** → Use when there's ONE obvious way to compare
2. **`PriorityQueue` auto-sorts using `compareTo()`** → No manual insertion logic needed
3. **Facade Pattern hides complexity** → Client only sees simple `add/get/size` methods
4. **Enum order matters!** → `HIGH, MEDIUM, LOW` gives correct `compareTo()` behavior
5. **Separate interface from implementation** → Easy to swap `PriorityQueue` for `Deque`
