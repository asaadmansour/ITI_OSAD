public class BinaryTree {
    private TreeNode root;
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
    public BinaryTree() {
        root = null;
    }
    private TreeNode createNode(int val) {
        return new TreeNode(val);
    }
    private void insertRecursive(TreeNode root, int val) {
        if(root == null) return;
        if(root.left == null) {
            root.left = createNode(val);
            return;
        }
        if(root.right == null) {
            root.right = createNode(val); 
            return;
        }
        insertRecursive(root.left, val);
    }
    public void insert(int val) {
        if (root == null) {
            root = createNode(val); 
            return;
        }
        insertRecursive(root, val);
    }
    private void PreOrderTraverseRecursive(TreeNode root) {
        if(root==null) return;
        System.out.println(root.data);
        PreOrderTraverseRecursive(root.left);
        PreOrderTraverseRecursive(root.right);
    }
    public void preOrderTraverse() {
        PreOrderTraverseRecursive(root);
    }
    private void InOrderTraverseRecursive(TreeNode root) {
        if(root==null) return;
        PreOrderTraverseRecursive(root.left);
        System.out.println(root.data);
        PreOrderTraverseRecursive(root.right);
    }
    public void InOrderTraverse() {
        InOrderTraverseRecursive(root);
    }
    private void PostOrderTraverseRecursive(TreeNode root) {
        if(root==null) return;
        PreOrderTraverseRecursive(root.left);
        System.out.println(root.data);
        PreOrderTraverseRecursive(root.right);
    }
    public void PostOrderTraverse() {
        PostOrderTraverseRecursive(root);
    }
        public void deleteNode(int val) {
        root = deleteRecursive(root, val);
    }

    private TreeNode deleteRecursive(TreeNode node, int val) {
        if (node == null) return null;

        if (node.data == val) {
            if (node.left == null && node.right == null) return null;
            if (node.left != null && node.right == null) return node.left;
            if (node.left == null && node.right != null) return node.right;

            // If node has both children: attach right child to the rightmost leaf of left subtree
            TreeNode rightSubtree = node.right;
            TreeNode leftSubtree = node.left;

            // Find the rightmost node in the left subtree
            TreeNode temp = leftSubtree;
            while (temp.right != null) temp = temp.right;

            temp.right = rightSubtree;

            return leftSubtree;
        }

        // Recurse
        node.left = deleteRecursive(node.left, val);
        node.right = deleteRecursive(node.right, val);

        return node;
    }

}