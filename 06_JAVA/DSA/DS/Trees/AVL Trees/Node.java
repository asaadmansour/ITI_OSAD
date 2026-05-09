class Node {
    Node left, right;
    int data;
    int height;

    Node(int val) {
        this.left = null;
        this.right = null;
        this.data = val;
        this.height = 1;
    }
    public void setHeight() {
        this.height = 1;
    }
}
