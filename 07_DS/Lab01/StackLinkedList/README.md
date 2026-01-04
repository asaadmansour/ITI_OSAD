# Stack (LinkedList-based) Implementation

## Overview
This directory contains a **Stack** data structure implementation using a Linked List as the underlying storage mechanism. A stack follows the LIFO (Last In, First Out) principle.

## Architecture
The Stack class is built on top of the LinkedList implementation from the parent directory (`../LinkedList/`). It uses the LinkedList's methods to provide stack-specific operations.

## Structure

### Stack (`Stack.h`, `Stack.cpp`)
- **Private Members:**
  - `LinkedList linkedList`: The underlying linked list that stores stack elements

## Methods

### Core Stack Operations
- `void push(int element)`: Adds an element to the top of the stack
  - Uses `linkedList.addNode()` internally
  - **Time Complexity:** O(1)
  
- `void pop()`: Removes the top element from the stack
  - Returns early if stack is empty
  - **Time Complexity:** O(n) - due to accessing the last element in the linked list
  
- `int peek()`: Returns the value at the top of the stack without removing it
  - **Time Complexity:** O(n) - due to accessing the last element
  
- `void display()`: Prints all elements in the stack from bottom to top
  - **Time Complexity:** O(n)

## Implementation Details
- The stack grows by adding nodes at the **end** of the linked list
- The "top" of the stack corresponds to the **tail** of the linked list
- Uses index-based access for peek and pop operations

## Usage Example
See `Main.cpp` for a demonstration of the Stack functionality.

## Files
- [`Stack.h`](file:///home/asaad/ITI-OSAD/07_DS/Lab01/StackLinkedList/Stack.h): Class declaration
- [`Stack.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab01/StackLinkedList/Stack.cpp): Class implementation
- [`Main.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab01/StackLinkedList/Main.cpp): Test program
