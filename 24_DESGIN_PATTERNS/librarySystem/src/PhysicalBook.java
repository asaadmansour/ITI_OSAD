public class PhysicalBook extends Book{

    public PhysicalBook(String title, BookObserver bookObserver) {
        super(title, bookObserver);
    }

    @Override
    public void borrowBook() {
        System.out.println("Physical Book borrowed: " + super.getTitle());
        super.borrowBook();
    }
}
