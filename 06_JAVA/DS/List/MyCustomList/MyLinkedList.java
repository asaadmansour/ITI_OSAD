package List.MyCustomList;

public class MyLinkedList<E> implements MyList<E> {

    private int size;
    private Node<E> head;
    private Node<E> tail;

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public MyLinkedList() {
        size = 0;
        head = tail = null;
    }

    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e, tail, null);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void clear() {
        Node<E> curr = head;
        while (curr != null) {
            Node<E> next = curr.next;
            curr.prev = null;
            curr.next = null;
            curr.item = null;
            curr = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> curr = head;
        while (curr != null) {
            if (o == null ? curr.item == null : o.equals(curr.item)) {
                Node<E> prev = curr.prev;
                Node<E> next = curr.next;

                if (prev != null) {
                    prev.next = next;
                } else {
                    head = next;
                }

                if (next != null) {
                    next.prev = prev;
                } else {
                    tail = prev; 
                }

                size--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.item;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> curr = head;
        while (curr != null) {
            if (o == null ? curr.item == null : o.equals(curr.item)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(MyList<E> c) {
        for (int i = 0; i < c.size(); i++) {
            E e = c.get(i);
            if (!this.contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        Node<E> curr = head;
        int i = 0;
        while (curr != null) {
            result[i++] = curr.item;
            curr = curr.next;
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }
}
