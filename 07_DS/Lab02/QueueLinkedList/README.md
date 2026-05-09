# Queue (LinkedList-based) Implementation

## Overview
This directory contains a **Queue** data structure implementation using a Linked List as the underlying storage mechanism. A queue follows the FIFO (First In, First Out) principle.

## Architecture
The Queue class is built on top of the LinkedList implementation from Lab01 (`../LinkedList/`). It uses the linked list's methods to provide queue-specific operations.

## Structure

### Queue (`Queue.h`, `Queue.cpp`)
- **Private Members:**
  - `LinkedList linkedList`: The underlying linked list that stores queue elements

## Methods

### Core Queue Operations
- `void enqueue(int element)`: Adds an element to the rear of the queue
  - Uses `linkedList.addNode()` internally
  - **Time Complexity:** O(1)
  
- `void dequeue()`: Removes the element from the front of the queue
  - Returns early if queue is empty
  - Removes the first element (at index 0)
  - **Time Complexity:** O(1)
  
- `int peek()`: Returns the value at the front of the queue without removing it
  - **Time Complexity:** O(1)
  
- `void display()`: Prints all elements in the queue from front to rear
  - **Time Complexity:** O(n)

## Implementation Details
- Elements are added at the **tail** of the linked list (rear of queue)
- Elements are removed from the **head** of the linked list (front of queue)
- This maintains FIFO ordering

## Usage Example
See `Main.cpp` for a demonstration of the Queue functionality.

## Files
- [`Queue.h`](file:///home/asaad/ITI-OSAD/07_DS/Lab02/QueueLinkedList/Queue.h): Class declaration
- [`Queue.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab02/QueueLinkedList/Queue.cpp): Class implementation
- [`Main.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab02/QueueLinkedList/Main.cpp): Test program
