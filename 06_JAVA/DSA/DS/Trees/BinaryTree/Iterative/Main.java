public class Main {
    public static void main(String[] args) {
        BinaryTree b1 = new BinaryTree();
        b1.insertNodeLevelOrder(10);
        b1.insertNodeLevelOrder(20);
        b1.insertNodeLevelOrder(30);
        b1.insertNodeLevelOrder(40);
        b1.insertNodeLevelOrder(50);
        b1.insertNodeLevelOrder(60);
        System.out.println(b1.getSize());
        // b1.preOrder();
        // b1.InOrder();
        // b1.PostOrder();
        // b1.LevelTraverse();
        if(b1.isNodeThere(22)) System.out.println("1");
        else System.out.println(0);
        if(b1.isNodeThere(20)) System.out.println("1");
        else System.out.println(0);
        b1.deleteNode(10);
        b1.LevelTraverse();
    }
}
