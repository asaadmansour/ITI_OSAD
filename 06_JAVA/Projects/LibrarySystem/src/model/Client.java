package model;
import java.util.List;
import java.util.ArrayList;
public class Client implements Identifiable {
    private Integer id;
    private String name;
    private String email;
    private List<LibraryItem> borrowedItems = new ArrayList<LibraryItem>();

    public Client(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public List<LibraryItem> getBorrowedItem() {
        return borrowedItems;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void borrowItem(LibraryItem item) {
        if(borrowedItems.contains(item)) {
            throw new IllegalStateException("You already have this item borrowed!");
        }
        if(!item.isAvailable()) {
            throw new IllegalStateException("Item is out of stock!");
        }
        borrowedItems.add(item);
        item.decrementStock();
    }
    public void returnItem(LibraryItem item) {
        if(!borrowedItems.contains(item)) {
            throw new IllegalStateException("You don't have this item borrowed!");    
        }
        borrowedItems.remove(item);
        item.incrementStock();
    }
}
