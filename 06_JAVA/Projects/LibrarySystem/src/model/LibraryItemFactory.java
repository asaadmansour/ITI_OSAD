package model;

public class LibraryItemFactory {
    public static LibraryItem create(int type, Integer id, Integer stock,String title) {
        switch (type) {
            case 1:
                return new Book(id,title,stock);
            case 2:
                return new Magazine(id,title,stock);
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }
}
