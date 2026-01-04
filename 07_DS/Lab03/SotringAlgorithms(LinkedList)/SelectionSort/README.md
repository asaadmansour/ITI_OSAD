# Selection Sort on Linked List

## Overview
This directory contains an implementation of **Selection Sort** algorithm for a Linked List data structure. Selection Sort works by repeatedly finding the minimum element and placing it at the beginning.

## Architecture
The SelectionSort class provides a static method that sorts a LinkedList in ascending order using the selection sort algorithm.

## Structure

### SelectionSort (`SelectionSort.h`, `SelectionSort.cpp`)
- **Static Methods:**
  - `static void sort(LinkedList& linkedList)`: Sorts the linked list in-place

## Method Details

### `sort(LinkedList& linkedList)`
- **Purpose:** Sorts a linked list in ascending order using selection sort
- **Parameters:**
  - `linkedList`: A reference to a LinkedList to be sorted (modified in-place)
- **Returns:** `void` (sorts in-place)
- **Time Complexity:** O(n²)
  - Always performs the same number of comparisons regardless of input
- **Space Complexity:** O(1) - sorts in-place

## Algorithm
1. Return early if list is empty
2. For each position in the list (outer loop)
3. Find the minimum element in the unsorted portion
4. Swap the minimum element with the current position
5. Continue until the entire list is sorted

## Implementation Details
- Uses `getNodeByIndex()` to access elements
- Uses `swapNodes()` to exchange values
- Divides list into sorted and unsorted portions
- Sorted portion grows from left to right

## Characteristics
- ✅ **Simple to understand**
- ✅ **In-place sorting**
- ✅ **Performs well with small datasets**
- ✅ **Minimizes number of swaps** (at most n-1 swaps)
- ❌ **Not stable** (may change relative order of equal elements)
- ❌ **Always O(n²)** regardless of input order
- ❌ **Not adaptive** (doesn't benefit from partially sorted data)

## Comparison with Other O(n²) Sorts
- **vs Bubble Sort:** Fewer swaps but same comparisons
- **vs Insertion Sort:** Not adaptive, but more consistent performance
- **Best for:** Situations where swap operations are expensive

## Usage Example
See `Main.cpp` for a demonstration of Selection Sort on a linked list.

## Files
- [`SelectionSort.h`](file:///home/asaad/ITI-OSAD/07_DS/Lab03/SotringAlgorithms(LinkedList)/SelectionSort/SelectionSort.h): Class declaration
- [`SelectionSort.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab03/SotringAlgorithms(LinkedList)/SelectionSort/SelectionSort.cpp): Implementation
- [`Main.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab03/SotringAlgorithms(LinkedList)/SelectionSort/Main.cpp): Test program
