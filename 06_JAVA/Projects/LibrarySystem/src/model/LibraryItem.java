package model;
import exception.ItemNotFoundException;

public abstract class LibraryItem implements Identifiable {
    private Integer id;
    private String title;
    private Integer stock;
    LibraryItem(Integer id, String title,Integer stock) {
        this.id = id;
        this.title = title;
        this.stock = stock;
    }
    LibraryItem() {
        this.id = null;
        this.title = null;
        this.stock = null;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public Integer getStock() {
        return stock;
    }
    public boolean isAvailable() {
        return stock > 0;
    }
    public void decrementStock() {
        if (stock <= 0) {
            throw new IllegalStateException("Cannot decrement, stock is already 0!");
        }
        stock--;
    }
    public void incrementStock() {
        stock++;
    }
    public abstract LibraryItem getItemDetails() throws ItemNotFoundException;

    @Override
    public String toString() {
        return String.valueOf(this.getId()) + " " + this.getTitle();
    }
}