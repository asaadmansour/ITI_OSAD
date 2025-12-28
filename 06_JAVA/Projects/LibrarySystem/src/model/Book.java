package model;

import exception.ItemNotFoundException;

public class Book extends LibraryItem {
    public Book(Integer id, String title,Integer stock) {
        super(id, title,stock);
    }

    @Override
    public LibraryItem getItemDetails() {
        if (this.getId() == null || this.getTitle() == null) {
            throw new ItemNotFoundException("Item Not Found!");
        }
        return this;
    }
}
