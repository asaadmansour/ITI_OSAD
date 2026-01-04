#include "math.h"
int maxDepth(TreeNode root) {
  if (root == nullptr)
    return 0;
  return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}
