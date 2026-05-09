public class HashTable {
    private Node[] table;
    private int sizee;
    HashTable(int size) {
        this.sizee = size;
        table = new Node[sizee];
    } 
    private int hashFn(int key) {
        return key % sizee;
    }
    public void put(int key,int value) {
        int index = hashFn(key);
        Node head = table[index];
        Node newNode = new Node(key, value);
        newNode.next = head;
        table[index] = newNode;
    }
    public Integer get(int key) {
        int index = hashFn(key);
        Node current = table[index];
        while(current != null) {
            if(current.key == key)
                return current.value;
            current = current.next;
        }
        return null;
    }
}
