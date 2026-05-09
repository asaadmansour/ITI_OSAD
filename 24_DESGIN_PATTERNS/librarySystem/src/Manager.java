public class Manager extends BorrowHandler {
    @Override
    public void handle(User user, BookInterface book) {
        if (!user.isVerfied()) {
            System.out.println("not authorized");
            return;
        }
        if (next != null) next.handle(user,book);
    }
}
