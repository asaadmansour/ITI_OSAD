# MyCustomList - Custom Java Collections Implementation

A custom implementation of Java's List interface with full **generics** support and **iterator** pattern implementation. This project demonstrates fundamental data structures concepts including linked lists, array lists, and the iterator design pattern.

---

## 📁 Project Structure

```
MyCustomList/
├── MyList.java           # Generic list interface (extends Iterable<E>)
├── MyLinkedList.java     # Doubly-linked list implementation
├── MyArrayList.java      # Dynamic array implementation (commented out)
├── ListIterator.java     # Bidirectional iterator interface
└── Main.java             # Test driver class
```

---

## 🔄 Understanding Iterators

### What is an Iterator?

An **Iterator** is a design pattern that provides a way to access elements of a collection sequentially without exposing the underlying structure. Think of it as a "cursor" that moves through your collection.

### How Iterators Work in Java Collections

```
┌─────────────────────────────────────────────────────────────────┐
│                        ITERATOR PATTERN                         │
├─────────────────────────────────────────────────────────────────┤
│                                                                 │
│   1. Collection implements Iterable<E>                          │
│      └── Must provide: Iterator<E> iterator()                   │
│                                                                 │
│   2. Iterator<E> interface provides:                            │
│      ├── boolean hasNext()  → Is there a next element?          │
│      ├── E next()           → Return next element, move cursor  │
│      └── void remove()      → Remove last returned element      │
│                                                                 │
│   3. The collection class defines HOW to iterate internally     │
│                                                                 │
└─────────────────────────────────────────────────────────────────┘
```

### In This Project

```java
// MyList interface extends Iterable<E>
public interface MyList<E> extends Iterable<E> { ... }

// MyLinkedList must implement iterator() method
public class MyLinkedList<E> implements MyList<E> {
    
    // Inner class that knows HOW to iterate through nodes
    private class IteratorImpl implements Iterator<E> {
        private Node<E> nextNode = head;  // Start at head
        
        public boolean hasNext() {
            return nextNode != null;      // More nodes to visit?
        }
        
        public E next() {
            E item = nextNode.item;       // Get current item
            nextNode = nextNode.next;     // Move cursor forward
            return item;
        }
    }
    
    // Factory method to create iterator
    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }
}
```

### Why Inner Classes for Iterators?

The iterator is an **inner class** because:
1. It needs access to the collection's private fields (`head`, `tail`, `size`)
2. It's tightly coupled to the specific implementation
3. Each collection type knows best how to traverse its own structure

### Iterator vs ListIterator

| Feature | Iterator | ListIterator |
|---------|----------|--------------|
| Direction | Forward only | Forward AND backward |
| Methods | `hasNext()`, `next()`, `remove()` | + `hasPrevious()`, `previous()`, `set()` |
| Use case | Simple traversal | Bidirectional traversal with modification |

---

## 🧬 Understanding Generics

### What are Generics?

**Generics** allow you to write code that works with different types while maintaining type safety at compile time. Instead of working with `Object` and casting, you parameterize your classes with type variables.

### Before Generics (Raw Types) ❌

```java
// Old way - not type-safe!
public class OldList {
    private Object[] items;
    
    public void add(Object item) { ... }
    public Object get(int index) { ... }
}

// Using it - requires casting, prone to errors
OldList list = new OldList();
list.add("Hello");
list.add(42);                    // No compile error! Mixed types
String s = (String) list.get(1); // Runtime ClassCastException!
```

### With Generics ✅

```java
// Modern way - type-safe!
public class MyList<E> {
    private E[] items;
    
    public void add(E item) { ... }
    public E get(int index) { ... }
}

// Using it - type-safe at compile time
MyList<String> list = new MyList<>();
list.add("Hello");
list.add(42);                    // Compile ERROR! Type mismatch
String s = list.get(0);          // No casting needed!
```

### Benefits of Generics

| Benefit | Description |
|---------|-------------|
| **Type Safety** | Errors caught at compile time, not runtime |
| **No Casting** | Compiler knows the type, no manual casting |
| **Code Reuse** | Same class works for String, Integer, any type |
| **Cleaner Code** | More readable without casting clutter |
| **IDE Support** | Better autocomplete and error detection |

### Generics in This Project

```java
// Type parameter <E> is declared here
public interface MyList<E> extends Iterable<E> {
    void add(E e);           // E is the element type
    E get(int index);        // Returns element of type E
    boolean containsAll(MyList<E> c);  // Works with same type
}

// Implementation uses same type parameter
public class MyLinkedList<E> implements MyList<E> {
    private Node<E> head;    // Node holds type E
    private Node<E> tail;
    
    // Inner class also parameterized with E
    private static class Node<E> {
        E item;              // The actual data of type E
        Node<E> prev;
        Node<E> next;
    }
}
```

### Type Parameter Naming Convention

| Symbol | Convention |
|--------|------------|
| `E` | Element (used in collections) |
| `T` | Type (general purpose) |
| `K` | Key (used in maps) |
| `V` | Value (used in maps) |
| `N` | Number |

---

## 🏗️ Class Diagram

```
                    ┌──────────────────┐
                    │   Iterable<E>    │  ← Java's built-in interface
                    │  + iterator(): E │
                    └────────┬─────────┘
                             │ extends
                    ┌────────▼─────────┐
                    │    MyList<E>     │  ← Our custom interface
                    │  + add(E)        │
                    │  + remove(E)     │
                    │  + get(int): E   │
                    │  + contains(E)   │
                    │  + size(): int   │
                    └────────┬─────────┘
                             │ implements
          ┌──────────────────┼──────────────────┐
          ▼                                     ▼
┌─────────────────┐                   ┌─────────────────┐
│ MyLinkedList<E> │                   │  MyArrayList<E> │
│ ─────────────── │                   │ ─────────────── │
│ - head: Node<E> │                   │ - array: E[]    │
│ - tail: Node<E> │                   │ - size: int     │
│ - size: int     │                   │ - capacity: int │
└─────────────────┘                   └─────────────────┘
         │
         │ contains
         ▼
┌─────────────────┐     ┌─────────────────┐
│    Node<E>      │     │  IteratorImpl   │ implements Iterator<E>
│ ────────────────│     │ ────────────────│
│ - item: E       │     │ - nextNode      │
│ - prev: Node<E> │     │ - lastReturned  │
│ - next: Node<E> │     │ + hasNext()     │
└─────────────────┘     │ + next()        │
                        │ + remove()      │
                        └─────────────────┘
```

---

## 📖 API Reference

### MyList Interface

| Method | Description |
|--------|-------------|
| `add(E e)` | Appends element to end of list |
| `remove(Object o)` | Removes first occurrence of element |
| `get(int index)` | Returns element at specified index |
| `contains(Object o)` | Returns true if list contains element |
| `containsAll(MyList<E> c)` | Returns true if list contains all elements |
| `toArray()` | Returns array containing all elements |
| `size()` | Returns number of elements |
| `clear()` | Removes all elements |
| `iterator()` | Returns an iterator over elements |

### ListIterator Interface

| Method | Description |
|--------|-------------|
| `hasPrevious()` | Returns true if more elements when traversing backwards |
| `previous()` | Returns previous element, moves cursor backwards |
| `set(E e)` | Replaces last returned element |
| `remove()` | Removes last returned element |

---

## 🚀 Usage Example

```java
// Create a typed list - only Strings allowed
MyLinkedList<String> names = new MyLinkedList<>();

// Add elements
names.add("Alice");
names.add("Bob");
names.add("Charlie");

// Using for-each loop (works because we implement Iterable!)
for (String name : names) {
    System.out.println(name);
}

// Using iterator directly
Iterator<String> iter = names.iterator();
while (iter.hasNext()) {
    String name = iter.next();  // No casting needed!
    if (name.equals("Bob")) {
        iter.remove();  // Safe removal during iteration
    }
}

// Type safety in action
MyLinkedList<Integer> numbers = new MyLinkedList<>();
numbers.add(42);
numbers.add("hello");  // ❌ Compile error! Can't add String to Integer list
```

---

## 🎯 Key Takeaways

1. **Generics** provide compile-time type safety and eliminate casting
2. **Iterators** decouple traversal logic from collection structure
3. Collections implement `Iterable<E>` to support for-each loops
4. Inner classes are ideal for iterators (access to private fields)
5. `ListIterator` extends `Iterator` with bidirectional support

---

## 📚 Related Java Interfaces

- `java.lang.Iterable<E>` - Allows for-each loop usage
- `java.util.Iterator<E>` - Forward traversal pattern
- `java.util.ListIterator<E>` - Bidirectional traversal (Java's version)
- `java.util.List<E>` - Java's standard list interface
