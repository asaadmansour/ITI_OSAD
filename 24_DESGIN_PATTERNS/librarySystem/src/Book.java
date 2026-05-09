import java.util.ArrayList;

public class Book implements BookInterface {
    private String title;
    private boolean isAvailable;
    private final BookObserver bookObserver;

    public Book(String title, BookObserver bookObserver) {
        this.title = title;
        this.isAvailable = true;
        this.bookObserver = bookObserver;
    }

    public void setAvailable(boolean availability) {
        this.isAvailable = availability;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public void borrowBook() {
        isAvailable = false;
        System.out.println(title + " has been borrowed.");
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
        bookObserver.setAvailability(true);
    }
}
