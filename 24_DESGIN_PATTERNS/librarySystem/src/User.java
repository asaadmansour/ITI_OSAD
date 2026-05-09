import java.util.ArrayList;
import java.util.List;

public class User implements Observer {
    private String name;
    private boolean isPremium;
    private boolean isVerified;
    List<BookInterface> borrowedBooks = new ArrayList<>();
    private List<String> notifications = new ArrayList<>();
    public User(String name) {
        this.name = name;
        this.isPremium = false;
        // added this as default if not passed
    }

    public User( String name,boolean isPremium,boolean isVerified) {
        this.isPremium = isPremium;
        this.name = name;
        this.isVerified = isVerified;
    }

    public String getName() {
        return name;
    }

    public boolean isVerfied() {
        return isVerified;
    }

    public void setVerfied(boolean verified) {
        isVerified = verified;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }
    public void addInBorrowedBooks(BookInterface book) {
        borrowedBooks.add(book);
    }
    public void removeFromBorrowedBooks(BookInterface book) {
        borrowedBooks.remove(book);
    }
    public List<BookInterface> getBorrowedBooks() {
        return borrowedBooks;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    @Override
    public void update(boolean bookAvailability) {
        String msg = bookAvailability
            ? "Book is now available for you, " + this.name + "!"
            : "A book you wanted is no longer available, " + this.name + ".";
        this.notifications.add(msg);
        System.out.println(msg);
    }
}
