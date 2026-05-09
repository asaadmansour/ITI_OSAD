# Binary Search on Linked List

## Overview
This directory contains an implementation of **Binary Search** algorithm adapted for a Linked List data structure.

> **⚠️ Note:** Binary Search on a linked list is generally inefficient compared to arrays because linked lists don't support random access. This implementation is for educational purposes.

## Architecture
The BinarySearch class provides a static method that performs binary search on a LinkedList from Lab01.

## Structure

### BinarySearch (`BinarySearch.h`, `BinarySearch.cpp`)
- **Static Methods:**
  - `static int indexOf(const LinkedList& linkedList, int target)`: Searches for a target value

## Method Details

### `indexOf(const LinkedList& linkedList, int target)`
- **Purpose:** Finds the index of a target value in a sorted linked list
- **Parameters:**
  - `linkedList`: A const reference to a sorted LinkedList
  - `target`: The integer value to search for
- **Returns:** 
  - The index of the target if found
  - `-1` if target is not found
- **Time Complexity:** O(n log n)
  - Each iteration: O(n) to access middle element
  - Number of iterations: O(log n)
- **Space Complexity:** O(1)

## Algorithm
1. Initialize `left` and `right` pointers to start and end indices
2. While `left <= right`:
   - Calculate middle index
   - Traverse to the middle node (O(n) operation)
   - Compare middle value with target
   - Adjust search range based on comparison
3. Return `-1` if not found

## Limitations
- **Inefficient for linked lists** due to lack of O(1) random access
- Better suited for sorted arrays
- Each middle element access requires O(n) traversal

## Usage Example
See `Main.cpp` for a demonstration of Binary Search on a linked list.

## Files
- [`BinarySearch.h`](file:///home/asaad/ITI-OSAD/07_DS/Lab03/SearchingAlgorithms(LinkedList)/BinarySearch/BinarySearch.h): Class declaration
- [`BinarySearch.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab03/SearchingAlgorithms(LinkedList)/BinarySearch/BinarySearch.cpp): Implementation
- [`Main.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab03/SearchingAlgorithms(LinkedList)/BinarySearch/Main.cpp): Test program
