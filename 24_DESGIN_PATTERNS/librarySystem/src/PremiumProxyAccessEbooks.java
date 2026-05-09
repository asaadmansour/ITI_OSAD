public class PremiumProxyAccessEbooks implements BookInterface{
    private BookInterface eBook;
    private final String title;
    private final BookObserver bookObserver;
    private User user;

    public PremiumProxyAccessEbooks(String title, BookObserver bookObserver, User user) {
        this.title = title;
        this.bookObserver = bookObserver;
        this.user = user;
    }
    @Override
    public void borrowBook() {
        if (!user.isPremium()) {
            System.out.println("Access denied. Premium membership required.");
            return;
        }
        eBook = new EBook(title, bookObserver);
        eBook.borrowBook();
    }

    @Override
    public void returnBook() {
        if(eBook != null)
            eBook.returnBook();
    }

    @Override
    public String getTitle() {
        return eBook.getTitle();
    }

    @Override
    public boolean isAvailable() {
        return eBook.isAvailable();
    }

    @Override
    public void setAvailable(boolean availability) {
        eBook.setAvailable(availability);
    }
}
