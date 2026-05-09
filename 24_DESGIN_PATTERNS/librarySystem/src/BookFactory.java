public class BookFactory {
    public static BookInterface getBook(BookType type, String title, BookObserver bookObserver) {
        switch (type) {
            case EBOOK:
                return new EBook(title, bookObserver);
            case HISTORICAL:
                return new HistoricalBook(title, bookObserver);
            case PHYSICAL:
                return new PhysicalBook(title, bookObserver);
            default:
                throw new IllegalArgumentException("Unknown type");
        }
    }
}