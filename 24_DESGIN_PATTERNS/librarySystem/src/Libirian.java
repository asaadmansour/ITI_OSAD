import java.util.ArrayList;

public class Libirian extends BorrowHandler{
    private BookObserver bookObserver;

    public Libirian(BookObserver bookObserver) {
        this.bookObserver = new BookObserver(new ArrayList<>());
    }
    @Override
    public void handle(User user, BookInterface book) {
        if (!book.isAvailable()) {
            System.out.println("Book is not available u will be notified once it is available.");
            bookObserver.registerObserver(user);
            return;
        }
        System.out.println("approved to next step!");
        if(next != null) next.handle(user,book);
    }
}
