package model;

import exception.ItemNotFoundException;

public class Magazine extends LibraryItem {
    public Magazine(Integer id, String title,Integer stock) {
        super(id, title,stock);
    }

    public Magazine() {
        super();
    }

    @Override
    public LibraryItem getItemDetails() {
        if (this.getId() == null || this.getTitle() == null) {
            throw new ItemNotFoundException("Item Not Found!");
        }
        return this;
    }
}
