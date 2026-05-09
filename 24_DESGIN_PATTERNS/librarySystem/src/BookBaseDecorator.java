public abstract class BookBaseDecorator implements BookInterface {
    private final BookInterface book;
    public BookBaseDecorator(BookInterface book) {
        this.book = book;
    }
    @Override public void borrowBook() { book.borrowBook(); }
    @Override public void returnBook() { book.returnBook(); }
    @Override public boolean isAvailable() { return book.isAvailable(); }
    @Override public String getTitle() { return book.getTitle(); }
    @Override public void setAvailable(boolean availability) { book.setAvailable(availability); }
}
