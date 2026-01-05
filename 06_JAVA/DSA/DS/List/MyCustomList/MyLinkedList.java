// package MyCustomList;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
    private class IteratorImpl implements Iterator<E> {
        private Node<E> nextNode = head;
        private Node<E> lastReturned = null;
        public boolean hasNext() {
            return nextNode != null;
        }
        public E next() {
            if(nextNode == null) throw new NoSuchElementException();
            lastReturned = nextNode;
            nextNode = nextNode.next;
            return lastReturned.item;
        }
        public void remove() {
            if(lastReturned == null) throw new IllegalStateException();
            if(lastReturned.prev == null) {
                head = lastReturned.next;
            } else {
                lastReturned.prev.next = lastReturned.next;
            }
            if(lastReturned.next == null) {
                tail = lastReturned.prev;
            } else {
                lastReturned.next.prev = lastReturned.prev;
            }
            lastReturned = null;
        }
    }
    private class ListIteratorImp implements ListIterator {
        private Node<E> nextNode = head;
        private Node<E> lastReturned = null;
        private Node<E> previousNode = null;
        public boolean hasPrevious(){
            return previousNode != null;
        }
        public Object previous() {
            if(previousNode == null) throw new NoSuchElementException();
            lastReturned = previousNode;
            nextNode = previousNode;
            previousNode = previousNode.prev;
            return lastReturned.item;
        }
        public void set(E e){
            if(lastReturned == null) throw new IllegalStateException();
            lastReturned.item = (E) e ;
        }
        public void remove(){}
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
    @Override
    public Iterator<E> iterator() {
        return new IteratorImpl();
    }
}
