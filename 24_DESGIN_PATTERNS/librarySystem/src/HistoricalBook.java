public class HistoricalBook extends Book {
    public HistoricalBook(String title, BookObserver bookObserver) {
        super(title, bookObserver);
    }
    @Override
    public void borrowBook() {
        System.out.println("Historical Book borrowed: " + super.getTitle());
        super.borrowBook();
    }
 }
