/**
 * @file max.cpp
 * @brief Function to calculate the maximum depth of a binary tree.
 */
#include "math.h"
int maxDepth(TreeNode root) {
  if (root == nullptr)
    return 0;
  return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}
