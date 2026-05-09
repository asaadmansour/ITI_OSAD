public abstract class BorrowHandler {
    protected BorrowHandler next;

    public BorrowHandler setNext(BorrowHandler next) {
        this.next = next;
        return next;
    }
    public abstract void handle(User user, BookInterface book);
}
