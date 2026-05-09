import java.util.ArrayList;

public class ExecutorHandler extends  BorrowHandler{

    @Override
    public void handle(User user, BookInterface book) {
        book.borrowBook();
        System.out.println("borrowed successfully");
    }
}
