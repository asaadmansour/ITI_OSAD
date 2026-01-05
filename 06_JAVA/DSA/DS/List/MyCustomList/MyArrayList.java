// package List.MyCustomList;

// public class MyArrayList<E> implements MyList<E> {

//     private Object[] array;
//     private int size;
//     private int capacity;

//     public MyArrayList(int initialCapacity) {
//         if (initialCapacity <= 0) {
//             throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
//         }
//         capacity = initialCapacity;
//         array = new Object[capacity];
//         size = 0;
//     }

//     @Override
//     public void add(E e) {
//         if (size == capacity) {
//             int newCapacity = capacity * 2;
//             Object[] newArray = new Object[newCapacity];
//             for (int i = 0; i < size; i++) {
//                 newArray[i] = array[i];
//             }
//             array = newArray;
//             capacity = newCapacity;
//         }
//         array[size++] = e;
//     }
//     @Override
//     public void clear(){
//         for(int i =0; i < size; i++) {
//             array[i] = null;
//         }
//         size = 0;
//     };
//     @Override
//     public boolean remove(Object o){
//         for(int i = 0; i < size; i++) {
//             if(o == null ? array[i] == null : o.equals(array[i])) {
//                 for(int j = i; j < size - 1; j++) {
//                     array[j] = array[j+1]; 
//                 }
//                 array[size - 1] = null;
//                 size--;
//                 return true;
//             }
//         }
//         return false;
//     };
//     @Override
//     public Object[] toArray(){
//         Object[] result = new Object[size];
//         for(int i = 0; i < size; i++) {
//             result[i] = array[i];
//         }
//         return result;
//     };
//     @Override
//     public int size(){
//         return size;
//     };
//     @Override
//     @SuppressWarnings("unchecked")
//         public E get(int index) {
//             if (index < 0 || index >= size) {
//                 throw new IndexOutOfBoundsException();
//             }
//             return (E) array[index];
//     };
//     @Override
//     public boolean contains(Object o){
//         for(int i = 0; i < size; i++) {
//             if(o == null ? array[i] == null : o.equals(array[i])) {
//                 return true;
//             }
//         }
//         return false;
//     };
//     @Override
//     public boolean containsAll(MyList<E> c){
//         for (int i = 0; i < c.size(); i++) {
//             E e = c.get(i);
//             if(!this.contains(e))
//                 return false;
//         }
//         return true;
//     }
// }
