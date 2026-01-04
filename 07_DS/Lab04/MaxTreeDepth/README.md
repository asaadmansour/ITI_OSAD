# Maximum Tree Depth

## Overview
This directory contains a function to calculate the **maximum depth** (or height) of a binary tree. The depth of a tree is the number of nodes along the longest path from the root node down to the farthest leaf node.

## Structure

### Function (`max.cpp`)
- `int maxDepth(TreeNode root)`: Calculates the maximum depth of a binary tree

## Method Details

### `maxDepth(TreeNode root)`
- **Purpose:** Calculates the maximum depth of a binary tree
- **Parameters:**
  - `root`: The root node of the binary tree
- **Returns:** 
  - `int`: The maximum depth of the tree
  - Returns `0` for an empty tree (null root)
- **Time Complexity:** O(n) - visits each node once
- **Space Complexity:** O(h) - where h is the height (due to recursion stack)

## Algorithm
The algorithm uses **recursion** with the following approach:

1. **Base Case:** If the root is `nullptr`, return 0
2. **Recursive Case:** 
   - Calculate the depth of the left subtree
   - Calculate the depth of the right subtree
   - Return 1 + max(left depth, right depth)

### Example
```
        1
       / \
      2   3
     / \
    4   5
```
- Depth of tree = 3
- Path: 1 → 2 → 4 (or 1 → 2 → 5)

## Implementation Details
- Uses `Math.max()` to find the maximum of left and right subtree depths
- The `+ 1` accounts for the current node
- Elegant recursive solution

## Binary Tree Properties
- **Leaf Node:** Depth = 1 (no children)
- **Empty Tree:** Depth = 0
- **Single Node:** Depth = 1

## Use Cases
- Analyzing tree balance
- Determining tree height for algorithm complexity
- Validating balanced trees (AVL, Red-Black)

## Files
- [`max.cpp`](file:///home/asaad/ITI-OSAD/07_DS/Lab04/MaxTreeDepth/max.cpp): Function implementation

## Note
This implementation assumes a `TreeNode` structure with `left` and `right` child pointers exists.
