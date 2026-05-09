public class BookAdapter implements EntityBook{
    private final ExternalBookService externalBookService;

    public BookAdapter(String book) {
        this.externalBookService = new ExternalBookService(book);
    }
    public BookInterface returnEntityBook() {
        String title = externalBookService.getBook().replace("jsonBook", "");
        return new Book(title);
    }
}
