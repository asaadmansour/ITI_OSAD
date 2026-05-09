public class BorrowRequestFacade {
    private final User user;
    private final BookInterface book;
    private final BookObserver bookObserver;

    public BorrowRequestFacade(User user, BookInterface book, BookObserver bookObserver) {
        this.user = user;
        this.book = book;
        this.bookObserver = bookObserver;
    }

    public void borrow() {
        Manager manager = new Manager();
        Libirian librarian = new Libirian(bookObserver);
        ExecutorHandler executor = new ExecutorHandler();
        manager.setNext(librarian).setNext(executor);
        manager.handle(user, book);
    }
}
