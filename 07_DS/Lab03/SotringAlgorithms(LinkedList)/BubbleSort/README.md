# Bubble Sort on Linked List

## Overview
This directory contains an implementation of **Bubble Sort** algorithm for a Linked List data structure. Bubble Sort is a simple comparison-based sorting algorithm.

## Architecture
The BubbleSort class provides a static method that sorts a LinkedList in ascending order using the bubble sort algorithm.

## Structure

### BubbleSort (`BubbleSort.h`, `BubbleSort.cpp`)
- **Static Methods:**
  - `static void sort(LinkedList& linkedList)`: Sorts the linked list in-place

## Method Details

### `sort(LinkedList& linkedList)`
- **Purpose:** Sorts a linked list in ascending order
- **Parameters:**
  - `linkedList`: A reference to a LinkedList to be sorted (modified in-place)
- **Returns:** `void` (sorts in-place)
- **Time Complexity:** O(n²)
  - Outer loop: n-1 iterations
  - Inner loop: n-i-1 iterations
- **Space Complexity:** O(1) - sorts in-place

## Algorithm
1. For each element from start to end (outer loop)
2. For each pair of adjacent elements (inner loop)
3. Compare adjacent elements using `getDataByIndex()`
4. If elements are out of order, swap them using `swapNodes()`
5. Repeat until no more swaps are needed

## Implementation Details
- Uses `getDataByIndex()` to access elements
- Uses `getNodeByIndex()` to get node references
- Uses `swapNodes()` to exchange values of adjacent nodes
- Optimized: inner loop reduces by i each iteration (already sorted elements)

## Characteristics
- ✅ **Simple to understand and implement**
- ✅ **Stable sort** (preserves relative order of equal elements)
- ✅ **In-place sorting** (minimal extra memory)
- ❌ **Inefficient for large datasets** (O(n²) time)
- ❌ **Multiple passes required**

## Usage Example
See `Main.cpp` for a demonstration of Bubble Sort on a linked list.

## Files
- [`BubbleSort.h`](file:///home/asaad/ITI-OSAD/07_DS/Lab03/SotringAlgorithms(LinkedList)/BubbleSort/BubbleSort.h): Class declaration
- [`BubbleSort.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab03/SotringAlgorithms(LinkedList)/BubbleSort/BubbleSort.cpp): Implementation
- [`Main.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab03/SotringAlgorithms(LinkedList)/BubbleSort/Main.cpp): Test program
