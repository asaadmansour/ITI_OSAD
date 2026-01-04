# Linear Search on Linked List

## Overview
This directory contains an implementation of **Linear Search** algorithm for a Linked List data structure. Linear search is the most straightforward search algorithm and works well with linked lists.

## Architecture
The LinearSearch class provides a static method that performs linear search on a LinkedList from Lab01.

## Structure

### LinearSearch (`LinearSearch.h`, `LinearSearch.cpp`)
- **Static Methods:**
  - `static int indexOf(const LinkedList& linkedList, int target)`: Searches for a target value

## Method Details

### `indexOf(const LinkedList& linkedList, int target)`
- **Purpose:** Finds the index of a target value in a linked list
- **Parameters:**
  - `linkedList`: A const reference to a LinkedList
  - `target`: The integer value to search for
- **Returns:** 
  - The index of the target if found
  - `-1` if target is not found
- **Time Complexity:** O(n)
  - Must potentially check every element
- **Space Complexity:** O(1)

## Algorithm
1. Start at the head of the linked list
2. Traverse through each node sequentially
3. Compare each node's value with the target
4. If match found, return the current index
5. If end of list reached without finding target, return `-1`

## Advantages
- **Simple implementation**
- **Works on unsorted lists**
- **Natural fit for linked lists** (sequential access)
- **No preprocessing required**

## Disadvantages
- **Slow for large lists** (O(n) worst case)
- Must check each element sequentially

## Usage Example
See `Main.cpp` for a demonstration of Linear Search on a linked list.

## Files
- [`LinearSearch.h`](file:///home/asaad/ITI-OSAD/07_DS/Lab03/SearchingAlgorithms(LinkedList)/LinearSearch/LinearSearch.h): Class declaration
- [`LinearSearch.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab03/SearchingAlgorithms(LinkedList)/LinearSearch/LinearSearch.cpp): Implementation
- [`Main.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab03/SearchingAlgorithms(LinkedList)/LinearSearch/Main.cpp): Test program
