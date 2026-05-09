public class PremiumBook extends BookBaseDecorator {
    public PremiumBook(BookInterface book) {
        super(book);
    }
    @Override
    public void borrowBook() {
        super.borrowBook();
        System.out.println("Premium: 10 extra days granted.");
    }
}
