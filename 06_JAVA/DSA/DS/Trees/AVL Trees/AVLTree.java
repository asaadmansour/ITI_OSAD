class AVLTree {
    private Node root;

    private Node createNode(int val) {
        return new Node(val);
    }

    private int getHeight(Node n) {
        return (n == null) ? 0 : n.height;
    }

    private void updateHeight(Node n) {
        if (n != null) {
            n.height = 1 + Math.max(getHeight(n.left), getHeight(n.right));
        }
    }

    private int balanceFactor(Node n) {
        if (n == null) return 0;
        return getHeight(n.left) - getHeight(n.right);
    }

    private Node rightRotate(Node n) {
        Node nodeLeft = n.left;
        Node nodeLeftRight = nodeLeft.right;
        nodeLeft.right = n;
        n.left = nodeLeftRight;
        updateHeight(n);
        updateHeight(nodeLeft);
        return nodeLeft;
    }

    private Node leftRotate(Node n) {
        Node nodeRight = n.right;
        Node nodeRightLeft = nodeRight.left;
        nodeRight.left = n;
        n.right = nodeRightLeft;
        updateHeight(n);
        updateHeight(nodeRight);
        return nodeRight;
    }

    public Node insert(Node node, int val) {
        Node newNode = createNode(val);
        if (node == null) {
            return newNode;
        }
        if (val < node.data) {
            node.left = insert(node.left, val);
        } else if (val > node.data) {
            node.right = insert(node.right, val);
        }
        updateHeight(node);
        int balance = balanceFactor(node); // Calculate once for efficiency

        // Case 1: Left-Left (LL) - Single Right Rotation
        if (balance > 1 && balanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        // Case 2: Left-Right (LR) - Double Rotation (Left then Right)
        if (balance > 1 && balanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Case 3: Right-Right (RR) - Single Left Rotation
        if (balance < -1 && balanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        // Case 4: Right-Left (RL) - Double Rotation (Right then Left)
        if (balance < -1 && balanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
}