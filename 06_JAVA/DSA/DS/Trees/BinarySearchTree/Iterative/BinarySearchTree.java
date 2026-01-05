import java.util.Stack;

public class BinarySearchTree {
    private TreeNode root;
    private int size;
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    private TreeNode createNode(int data) {
        return new TreeNode(data);
    }
    private boolean isEmpty() {
        return root == null;
    }

    public void insertNode(int val) {
        TreeNode insertedNode = createNode(val);
        if(root == null) {
            root = insertedNode;
            size++;
            return;
        }
        TreeNode curr = root;
        while(true) {
            if(val < curr.data) {
                if(curr.left == null) {
                    curr.left = insertedNode;
                    break;
                }
                curr = curr.left;
            }
            else if(val > curr.data) {
                if(curr.right == null) {
                    curr.right = insertedNode;
                    break;
                }
                curr = curr.right;
            } else {
                    return;
            }
        }
        size++;
    }
    public void InOrder() {
        if(isEmpty()) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current!=null || !stack.isEmpty()) {
            while (current!=null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.println(current.data);
            current = current.right;
        }
    }
    public void PreOrder() {
        if(isEmpty()) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.println(current.data);
            if(current.right != null) {
                stack.push(current.right);
            }
            if(current.left != null) {
                stack.push(current.left);
            }
        }
    }
    public void PostOrder() {
        if(isEmpty()) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null;
        TreeNode current = root;
        while (current!=null || !stack.isEmpty()) {
            if(current!= null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode peekNode = stack.peek();
                if(peekNode.right!=null && peekNode.right != lastVisited) {
                    current = peekNode.right;
                } else {
                    System.out.println(peekNode.data);
                    lastVisited = stack.pop();
                }
            }
        }
    }
    private TreeNode getParent(TreeNode child) {
        if(root == null || child == null || child == root)
            return null;
        TreeNode curr = root;
        while(curr != null) {
            if(child.data < curr.data) {
                if(curr.left == child) return curr;
                curr = curr.left;
            } else if(child.data > curr.data) {
                if(curr.right == child) return curr;
                curr = curr.right;
            } else {
                return null; 
            }
        }
        return null; 
    }
    private TreeNode getSuccessor(int val) {
        TreeNode node = findNodeByData(val);
        if(node == null) return null;
        if(node.right != null) {
            TreeNode curr = node.right;
            while(curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }
        TreeNode curr = root;
        TreeNode successor = null;
        while(curr!=null) {
            if(node.data < curr.data) {
                successor = curr;
                curr = curr.left;
            } else if(node.data>curr.data) {
                curr = curr.right;
            } else {
                break;
            }
        }
        return successor;
    } 
    private TreeNode findNodeByData(int data) {
        TreeNode curr = root;
        while (curr != null) {
            if (data == curr.data) return curr;
            if (data < curr.data) curr = curr.left;
            else curr = curr.right;
        }
        return null;
    }
    private void deleteNodeInternal(TreeNode node) {
        if (node == null) return;
        TreeNode parent = getParent(node);

        // Case 1: node is a leaf
        if (node.left == null && node.right == null) {
            if (parent == null) {
                root = null;
            } else if (parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        // Case 2: node has only one child
        else if (node.left == null || node.right == null) {
            TreeNode child = (node.left != null) ? node.left : node.right;
            if (parent == null) {
                root = child;
            } else if (parent.left == node) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
        // Case 3: node has two children
        else {
            TreeNode succParent = node;
            TreeNode succ = node.right;
            while (succ.left != null) {
                succParent = succ;
                succ = succ.left;
            }
            node.data = succ.data;
            if (succParent.left == succ) {
                succParent.left = succ.right;
            } else {
                succParent.right = succ.right;
            }
        }
        size = Math.max(0, size - 1);
    }

    public void deleteNode(int data) {
        TreeNode node = findNodeByData(data);
        deleteNodeInternal(node);
    }

}
        // TreeNode parent = getParent(node);
        // if(node.left == null && node.right == null) {
        //     if(parent.left == node) {
        //         parent.left = null;
        //     } else {
        //         parent.right = null;
        //     }
        // } else if(node.left != null && node.right == null) {
        //     if(parent.left == node) {
        //         parent.left = node.left;
        //     } else {
        //         parent.right = node.left;
        //     }
        // } else if(node.left == null && node.right != null) {
        //     if(parent.left == node) {
        //         parent.left = node.right;
        //     } else {
        //         parent.right = node.right;
        //     }
        // } else {
        //     TreeNode predecessor = getPredecessor(node);
        //     TreeNode predecssorParent = getParent(predecessor);
        //     if(predecssorParent.right == predecessor) {
        //         predecssorParent.right = predecessor.left;
        //     }
        //     predecessor.left = node.left;
        //     predecessor.right =  node.right;
        //     if(parent.left == node) {
        //         parent.left = predecessor;
        //     } else {
        //         parent.right = predecessor;
        //     }
        // }
        // node = null;