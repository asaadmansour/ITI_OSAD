package service;

import model.Library;
import model.LibraryItem;
import model.LibraryItemFactory;
import exception.ItemNotFoundException;

public class LibraryService {
    Library<LibraryItem> lib1;

    public LibraryService(Library<LibraryItem> library) {
        this.lib1 = library;
    }

    public void addItem(Integer type, int itemId, String title, int stock) {
        if (lib1.findById(itemId) != null) {
            throw new IllegalStateException("Item ID already exists!");
        }
        LibraryItem item = LibraryItemFactory.create(type, itemId, stock, title);
        lib1.addItem(item);
    }

    public LibraryItem getItemById(int itemId) throws ItemNotFoundException {
        return lib1.findByIdOrThrow(itemId);
    }

    public void updateTitle(int itemId, String newTitle) throws ItemNotFoundException {
        LibraryItem item = lib1.findByIdOrThrow(itemId);
        item.setTitle(newTitle);
    }

    public void deleteItem(int itemId) throws ItemNotFoundException {
        LibraryItem item = lib1.findByIdOrThrow(itemId);
        lib1.removeItem(item);
    }

    public boolean isIdUnique(int id) {
        return lib1.findById(id) == null;
    }
}
