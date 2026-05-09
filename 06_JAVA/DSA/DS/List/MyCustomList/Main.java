package List.MyCustomList;

import java.util.Iterator;

// import List.MyCustomList.MyArrayList;
import List.MyCustomList.MyLinkedList;
import List.MyCustomList.MyList;

public class Main {

    public static void main(String[] args) {

        // ------------------ Testing MyArrayList ------------------
        // MyArrayList<String> list = new MyArrayList<>(2);

        // list.add("A");
        // list.add("B");
        // list.add("C");  // triggers resize

        // System.out.println("MyArrayList after adds:");
        // printList(list);

        // System.out.println("Element at index 1: " + list.get(1));

        // System.out.println("Contains 'B'? " + list.contains("B"));
        // System.out.println("Contains 'D'? " + list.contains("D"));

        // list.remove("B");
        // System.out.println("MyArrayList after removing 'B':");
        // printList(list);

        // MyArrayList<String> subList = new MyArrayList<>(2);
        // subList.add("A");
        // subList.add("C");
        // System.out.println("Contains all elements of subList? " + list.containsAll(subList));

        // Object[] arrayCopy = list.toArray();
        // System.out.print("Array copy: ");
        // for (Object o : arrayCopy) {
        //     System.out.print(o + " ");
        // }
        // System.out.println();

        // System.out.println("Size of MyArrayList: " + list.size());

        // list.clear();
        // System.out.println("MyArrayList after clear, size: " + list.size());


        // ------------------ Testing MyLinkedList ------------------
        MyLinkedList<String> list2 = new MyLinkedList<>();

        list2.add("A");
        list2.add("B");
        list2.add("C");
        Iterator<String> iter = list2.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("\nMyLinkedList after adds:");
        printList(list2);

        System.out.println("Element at index 1: " + list2.get(1));

        System.out.println("Contains 'B'? " + list2.contains("B"));
        System.out.println("Contains 'D'? " + list2.contains("D"));

        list2.remove("B");
        System.out.println("MyLinkedList after removing 'B':");
        printList(list2);

        MyLinkedList<String> sublist2 = new MyLinkedList<>();
        sublist2.add("A");
        sublist2.add("C");
        System.out.println("Contains all elements of sublist2? " + list2.containsAll(sublist2));

        Object[] arrayCopy2 = list2.toArray();
        System.out.print("Array copy: ");
        for (Object o : arrayCopy2) {
            System.out.print(o + " ");
        }
        System.out.println();

        System.out.println("Size of MyLinkedList: " + list2.size());

        list2.clear();
        System.out.println("MyLinkedList after clear, size: " + list2.size());
    }

    // private static void printList(MyArrayList<?> list) {
    //     for (int i = 0; i < list.size(); i++) {
    //         System.out.print(list.get(i) + " ");
    //     }
    //     System.out.println();
    // }

    private static void printList(MyLinkedList<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
