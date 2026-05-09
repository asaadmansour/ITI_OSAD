# Task 1: Thread Creation - Four Different Ways

## 📋 Task Description
Create and start a thread that prints its name for around 5 seconds (one time per second). Demonstrate thread creation using four different approaches.

## 📁 File Structure

```
One/
├── One.java                              # Main class - demonstrates all 4 methods
├── NamePrinterExternalRunnable.java      # Method 1: Runnable implementation
├── MyThreadClass.java                    # Method 2: Thread extension
└── README.md                             # This file
```

## 🎯 Four Methods Demonstrated

### Method 1: Separate Class Implementing Runnable
**File:** `NamePrinterExternalRunnable.java`
```java
NamePrinterExternalRunnable runnable = new NamePrinterExternalRunnable();
Thread runnableThread = new Thread(runnable);
runnableThread.start();
```

### Method 2: Extending Thread Class
**File:** `MyThreadClass.java`
```java
MyThreadClass extendedThread = new MyThreadClass();
extendedThread.start();
```

### Method 3: Lambda Function
**Location:** Inside `One.java` main method
```java
Thread lambdaThread = new Thread(() -> {
    // Thread logic here
});
lambdaThread.start();
```

### Method 4: Method Reference
**Location:** Inside `One.java` main method
```java
Thread methodRefThread = new Thread(One::printThreadName);
methodRefThread.start();
```

## 🚀 How to Run

```bash
# Compile
javac One.java

# Run
java One
```

## 📊 Expected Output

```
=== Starting All 4 Thread Creation Methods ===

Method 1: Creating thread with Runnable implementation
Method 2: Creating thread by extending Thread class
Method 3: Creating thread with lambda function
Method 4: Creating thread with method reference

=== All threads started! ===

Thread-0
Thread-1
Thread-2
Thread-3
... (threads print their names concurrently)
```

## 🎓 Key Concepts Learned

- ✅ Creating threads with Runnable interface
- ✅ Creating threads by extending Thread class
- ✅ Using lambda expressions with threads
- ✅ Using method references with threads
- ✅ Understanding concurrent execution
- ✅ Exception handling with Thread.sleep()

## 📝 Notes

- All four threads run **concurrently** (at the same time)
- Each thread prints its name 5 times with 1-second intervals
- Thread names are automatically assigned (Thread-0, Thread-1, etc.)
