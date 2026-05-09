public class ExternalBookService {
    private final String book;
    public ExternalBookService(String book) {
        this.book = book;
    }

    public String getBook() {
        return "jsonBook" + book;
    }
}
