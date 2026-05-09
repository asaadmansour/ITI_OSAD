public class EBook extends Book{

    public EBook(String title, BookObserver bookObserver) {
        super(title, bookObserver);
    }

    @Override
    public void borrowBook() {
        System.out.println("E-Book borrowed: " + super.getTitle());
        super.borrowBook();
    }
}
