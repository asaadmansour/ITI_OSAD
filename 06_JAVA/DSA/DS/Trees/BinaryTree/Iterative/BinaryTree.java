import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    private TreeNode root;
    int size;
    class TreeNode {
        int data;
        TreeNode right;
        TreeNode left;
        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }
    private TreeNode createNode(int data) {
        return new TreeNode(data);
    }
    public boolean isNodeThere(int val) {
        if(isEmpty()) return false;
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);
        while(!treeQueue.isEmpty()) {
            TreeNode current = treeQueue.poll();
            if(current.data == val) return true;
            if(current.left != null)
                treeQueue.add(current.left);
            if(current.right!=null)
                treeQueue.add(current.right);
        }
        return false;
    }
    public void insertNodeLevelOrder(int data) {
        if(root == null) {
            root = createNode(data);
            size++;
            return;   
        }
        TreeNode insertedNode = new TreeNode(data);
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);
        while(!treeQueue.isEmpty()) {
            TreeNode current = treeQueue.poll();
            if(current.left == null){
                current.left = insertedNode;
                break;
            }
            if(current.right == null) {
                current.right = insertedNode;
                break;
            }
            treeQueue.add(current.left);
            treeQueue.add(current.right);
        }
        size++;
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return root == null;
    }
    /////////////////// TRAVERSALS //////////////////////////////////
    //// PreOrder//// ROOT LEFT RIGHT
    public void preOrder() {
        if(isEmpty()) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.println(current.data);
            if(current.right != null) 
                stack.push(current.right);
            if(current.left!=null)
                stack.push(current.left);
        }
    }
    /// InOrder /// LEFT ROOT RIGHT
    public void InOrder() {
        if(isEmpty()) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current!= null || !stack.isEmpty()) {
            while(current!=null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.println(current.data);
            current = current.right;
        }
    }
    /// PostOrder /// LEFT RIGHT ROOT
    public void PostOrder() {
        if(isEmpty()) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisted = null;
        while(current!= null || !stack.isEmpty()) {
            if(current!=null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode peekedNode = stack.peek();
                if(peekedNode.right!=null && lastVisted != peekedNode.right) {
                    current = peekedNode.right;
                } else {
                    System.out.println(peekedNode.data);
                    lastVisted = stack.pop();
                }
            }
        }
    }
    /// LevelTraverse
    public void LevelTraverse() {
        if(isEmpty()) return;
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);
        while(!treeQueue.isEmpty()) {
            TreeNode current = treeQueue.poll();
            System.out.println(current.data);
            if(current.left != null) 
                treeQueue.add(current.left);
            if(current.right!=null)
                treeQueue.add(current.right);
        }
    }
    public void deleteNode(int val) {
        if(isEmpty() || !isNodeThere(val)) return;
            if (root.left == null && root.right == null) { 
                if (root.data == val) root = null;
                return;
            }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode target = null;
        TreeNode lastNode = null;
        TreeNode parentOfLast = null;
        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if(current.data == val) target = current;
            if(current.left != null) {
                parentOfLast = current;
                queue.add(current.left);
            }
            if(current.right != null) {
                parentOfLast = current;
                queue.add(current.right);
            }
            lastNode = current;
        }
            if (target != null) {
            target.data = lastNode.data; 
            
            if (parentOfLast.left == lastNode) parentOfLast.left = null;
            else if (parentOfLast.right == lastNode) parentOfLast.right = null;
            size--;
        }
    }
}