public interface ListIterator<E> {
    /**
     * Returns true if this list iterator has more elements when 
     * traversing the list in the reverse direction.
     * @return true if there are more elements when traversing backwards
     */
    boolean hasPrevious();

    /**
     * Returns the previous element in the list and moves the cursor 
     * position backwards.
     * @return the previous element in the list
     */
    E previous();

    /**
     * Replaces the last element returned by next or previous with 
     * the specified element.
     * @param e the element to set
     */
    void set(E e);

    /**
     * Removes from the list the last element that was returned by 
     * next or previous.
     */
    void remove();
}
