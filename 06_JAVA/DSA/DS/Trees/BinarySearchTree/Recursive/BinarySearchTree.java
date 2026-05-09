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
    public void insertNode(int val) {
        root = insertNodeHelper(root, val);
    }
    private TreeNode insertNodeHelper(TreeNode curr,int value) {
        if(curr == null) {
            return createNode(value);
        }
        if(value < curr.data) 
            curr.left = insertNodeHelper(curr.left,value);
        else if(value> curr.data)
            curr.right = insertNodeHelper(curr.right,value);
        return curr;
    }
    public void PreOrder() {
        PreOrderHelper(root);
    }
    private void PreOrderHelper(TreeNode root) {
        if(root == null) return;
        System.out.println(root.data);
        PreOrderHelper(root.left);
        PreOrderHelper(root.right);
    }
    public void InOrder() {
        InOrderHelper(root);
    }
    private void InOrderHelper(TreeNode root) {
        if(root == null) return;
        InOrderHelper(root.left);
        System.out.println(root.data);
        InOrderHelper(root.right);
    }
    public void PostOrder() {
        PostOrderHelper(root);
    }
    private void PostOrderHelper(TreeNode root) {
        if(root == null) return;
        PostOrderHelper(root.left);
        PostOrderHelper(root.right);
        System.out.println(root.data);
    }
    private TreeNode findMin(TreeNode node) {
        while(node.left!=null)
            node = node.left;
        return node;
    }
    private TreeNode deleteRecursivly(TreeNode node,int data) {
        if(node == null) return null;
        if(data < node.data) {
            node.left = deleteRecursivly(node.left, data);
        } else if(data > node.data) {
            node.right = deleteRecursivly(node.right, data);
        } else {
            //case 1
            if(node.left == null) return node.right;
            if(node.right == null) return node.left;
            // case 2++
            TreeNode successor = findMin(node.right);
            node.data = successor.data;
            node.right = deleteRecursivly(node.right, successor.data);
        }
        return node;
    }
    public void deleteNode(int value) {
        root = deleteRecursivly(root, value);
        size--;
    }

}