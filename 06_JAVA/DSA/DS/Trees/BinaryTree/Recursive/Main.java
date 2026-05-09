public class Main {
    public static void  main(String[] args) {
        BinaryTree b1 = new BinaryTree();
        b1.insert(10);
        b1.insert(20);
        b1.insert(30);
        b1.insert(40);
        b1.insert(50);
        b1.InOrderTraverse();
        b1.PostOrderTraverse();
        b1.preOrderTraverse();
    }
    
}
