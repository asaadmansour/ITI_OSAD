# Dequeue (Double Ended Queue) Implementation

## Overview
This directory contains a **Dequeue** (Double Ended Queue) implementation using a Linked List. A dequeue allows insertion and deletion operations at both ends of the queue.

## Architecture
The Dequeue class is built on top of the LinkedList implementation from Lab01 (`../LinkedList/`). It uses the doubly linked nature of the list to efficiently support operations at both ends.

## Structure

### Dequeue (`Dequeue.h`, `Dequeue.cpp`)
- **Private Members:**
  - `LinkedList linkedList`: The underlying linked list that stores dequeue elements

## Methods

### Front Operations
- `void enqueueFront(int val)`: Adds an element to the front of the dequeue
  - Uses `linkedList.insertAtHead()` if list is empty, otherwise `linkedList.addNode()`
  - **Time Complexity:** O(1)
  
- `void dequeueFront()`: Removes the element from the front of the dequeue
  - Returns early if dequeue is empty
  - **Time Complexity:** O(1)

### Rear Operations
- `void enqueueRear(int val)`: Adds an element to the rear of the dequeue
  - Uses `linkedList.addNode()` internally
  - **Time Complexity:** O(1)
  
- `void dequeueRear()`: Removes the element from the rear of the dequeue
  - Returns early if dequeue is empty
  - **Time Complexity:** O(1)

### Utility Methods
- `bool isEmpty()`: Checks if the dequeue is empty
  - **Time Complexity:** O(1)
  
- `void display()`: Prints all elements in the dequeue
  - **Time Complexity:** O(n)

## Implementation Details
- Supports insertion and deletion at both ends (head and tail)
- More flexible than a standard queue
- Useful for algorithms requiring bidirectional access

## Usage Example
See `main.cpp` for a demonstration of the Dequeue functionality.

## Files
- [`Dequeue.h`](file:///home/asaad/ITI-OSAD/07_DS/Lab02/DoubleEndedQueue/Dequeue.h): Class declaration
- [`Dequeue.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab02/DoubleEndedQueue/Dequeue.cpp): Class implementation
- [`main.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab02/DoubleEndedQueue/main.cpp): Test program
