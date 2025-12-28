package model;

import java.util.ArrayList;
import exception.ItemNotFoundException;

public class Library<T extends LibraryItem> {
    ArrayList<T> items = new ArrayList<>();

    public void addItem(T item) {
        if (item.getItemDetails() != null) {
            items.add(item);
        } else {
            throw new ItemNotFoundException("Item not found!");
        }
    }
    public ArrayList<T> getItems() {
        return items;
    }
    public boolean removeItem(T obj) {
        return items.remove(obj);  
    }
    public void displayItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }
    public T findById(int id) {
        for (T item : items) {
            if (id == item.getId()) {
                return item;
            }
        }
        return null;
    }

    public T findByIdOrThrow(int id) throws ItemNotFoundException {
        T item = findById(id);
        if (item == null) {
            throw new ItemNotFoundException("Item not found with ID: " + id);
        }
        return item;
    }
}
