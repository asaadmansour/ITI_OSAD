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
    public void insertNode(int data) {
        if(isEmpty()) {
            root = createNode(data);
            size++;
            return;
        }
        TreeNode current = root;
        TreeNode insertedNode = createNode(data);
        while(true) {
            if(data < current.data) {
                if(current.left == null) {
                    current.left = insertedNode;
                    break;
                    }
                current = current.left;
                }
                else if(data > current.data) {
                    if(current.right == null) {
                    current.right = insertedNode;
                    break;
                }
                current = current.right;
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

}