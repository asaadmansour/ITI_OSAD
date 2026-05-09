# LinkedList Implementation

## Overview
This directory contains a **Doubly Linked List** implementation in C++. A doubly linked list is a data structure where each node contains a value and pointers to both the next and previous nodes, allowing bidirectional traversal.

## Structure

### Node (`Node.h`, `Node.cpp`)
- **Fields:**
  - `int val`: The integer value stored in the node
  - `Node* next`: Pointer to the next node
  - `Node* prev`: Pointer to the previous node
- **Constructors:**
  - `Node()`: Default constructor (initializes value to 0 and pointers to nullptr)
  - `Node(int val)`: Constructor with value

### LinkedList (`LinkedList.h`, `LinkedList.cpp`)
- **Private Members:**
  - `int count`: Number of nodes in the list
  - `Node* head`: Pointer to the first node
  - `Node* tail`: Pointer to the last node

## Methods

### Constructors & Destructor
- `LinkedList()`: Creates an empty linked list
- `LinkedList(const LinkedList& other)`: Copy constructor
- `~LinkedList()`: Destructor that frees all nodes

### Insertion Methods
- `void addNode(int val)`: Adds a node at the end of the list
- `void insertAtHead(int val)`: Inserts a node at the beginning
- `void insertAfter(int val, int target)`: Inserts a node after the first occurrence of target value
- `void insertBefore(int val, int target)`: Inserts a node before the first occurrence of target value

### Deletion Methods
- `void removeNode(int val)`: Removes the first node with the specified value
- `void removeAll(int data)`: Removes all nodes with the specified value

### Access Methods
- `Node* getHead()`: Returns the head node
- `void setHead(Node* node)`: Sets the head pointer
- `int getDataByIndex(int index) const`: Returns the value at the specified index
- `Node* getNodeByIndex(int index) const`: Returns the node at the specified index
- `int getCount() const`: Returns the number of nodes
- `bool isEmpty() const`: Checks if the list is empty

### Utility Methods
- `void display()`: Prints all values in the list
- `void swapNodes(Node* one, Node* two)`: Swaps the values of two nodes

## Usage Example
See `Main.cpp` for a demonstration of the LinkedList functionality.

## Files
- [`LinkedList.h`](file:///home/asaad/ITI-OSAD/07_DS/Lab01/LinkedList/LinkedList.h): Class declaration
- [`LinkedList.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab01/LinkedList/LinkedList.cpp): Class implementation
- [`Node.h`](file:///home/asaad/ITI-OSAD/07_DS/Lab01/LinkedList/Node.h): Node structure declaration
- [`Node.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab01/LinkedList/Node.cpp): Node implementation
- [`Main.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab01/LinkedList/Main.cpp): Test program
