import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryService {
    //static for calling it with classname
    private static volatile LibraryService instance;
    private List<BookInterface> books = new ArrayList<>();
    // private constructor for singleton
    private LibraryService(){

    }
    //method for getting the instance
    public static LibraryService getInstance() {
        if(instance == null) {
            synchronized (LibraryService.class) {
                if (instance == null) {
                    instance = new LibraryService();
                }
            }
        }
        return instance;
    }
    public void addBook(BookInterface book) {
        books.add(book);
    }

    public BookInterface findBook(String title) {
        for (BookInterface book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String title,User user) {
        BookInterface book = findBook(title);
        if (book != null && book.isAvailable()) {
            book.borrowBook();
            book.setAvailable(false);
            user.addInBorrowedBooks(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(String title,User user) {
        BookInterface book = findBook(title);
        if (book != null) {
            book.returnBook();
            book.setAvailable(true);
            user.removeFromBorrowedBooks(book);
        } else {
            System.out.println("Book not found.");
        }
    }

}
