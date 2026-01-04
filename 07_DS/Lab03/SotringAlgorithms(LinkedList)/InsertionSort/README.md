# Insertion Sort on Linked List

## Overview
This directory contains an implementation of **Insertion Sort** algorithm for a Linked List data structure. Insertion Sort builds the sorted list one element at a time by inserting elements into their correct position.

## Architecture
The InsertionSort class provides a static method that sorts a LinkedList in ascending order using the insertion sort algorithm.

## Structure

### InsertionSort (`InsertionSort.h`, `InsertionSort.cpp`)
- **Static Methods:**
  - `static void sort(LinkedList& linkedList)`: Sorts the linked list in-place

## Method Details

### `sort(LinkedList& linkedList)`
- **Purpose:** Sorts a linked list in ascending order using insertion sort
- **Parameters:**
  - `linkedList`: A reference to a LinkedList to be sorted (modified in-place)
- **Returns:** `void` (sorts in-place)
- **Time Complexity:** 
  - **Best case:** O(n) - when list is already sorted
  - **Average/Worst case:** O(n²)
- **Space Complexity:** O(1) - sorts in-place

## Algorithm
1. Iterate through the list starting from the second element
2. For each element, find its correct position in the sorted portion
3. Insert the element at the correct position
4. Continue until all elements are processed

## Implementation Details
- Works well with linked lists due to efficient insertions
- Better than bubble sort for nearly sorted data
- Adaptive algorithm (faster for partially sorted data)

## Characteristics
- ✅ **Simple and intuitive**
- ✅ **Stable sort** (preserves relative order of equal elements)
- ✅ **Adaptive** (efficient for nearly sorted data)
- ✅ **In-place sorting**
- ✅ **Good for small datasets**
- ❌ **Inefficient for large datasets** (O(n²) average case)

## Comparison with Bubble Sort
- Generally faster than Bubble Sort for random data
- Better for nearly sorted data
- More efficient in practice

## Usage Example
See `Main.cpp` for a demonstration of Insertion Sort on a linked list.

## Files
- [`InsertionSort.h`](file:///home/asaad/ITI-OSAD/07_DS/Lab03/SotringAlgorithms(LinkedList)/InsertionSort/InsertionSort.h): Class declaration
- [`InsertionSort.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab03/SotringAlgorithms(LinkedList)/InsertionSort/InsertionSort.cpp): Implementation
- [`Main.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab03/SotringAlgorithms(LinkedList)/InsertionSort/Main.cpp): Test program
