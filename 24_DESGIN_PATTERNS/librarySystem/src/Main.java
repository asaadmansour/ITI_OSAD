import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LibraryService library = LibraryService.getInstance();
        LibraryService library2 = LibraryService.getInstance();
        System.out.println("Same instance: " + (library == library2));

        BookObserver hpObserver   = new BookObserver(new ArrayList<>());
        BookObserver lotrObserver = new BookObserver(new ArrayList<>());
        BookObserver ccObserver   = new BookObserver(new ArrayList<>());

        library.addBook(BookFactory.getBook(BookType.PHYSICAL,   "Harry Potter",      hpObserver));
        library.addBook(BookFactory.getBook(BookType.HISTORICAL, "Lord of the Rings", lotrObserver));
        library.addBook(BookFactory.getBook(BookType.EBOOK,      "Clean Code",        ccObserver));

        BookAdapter externalCatalog = new BookAdapter("Design Patterns");
        library.addBook(externalCatalog.returnEntityBook());

        System.out.println("Library is open. Books on shelf:");
        System.out.println("  - Harry Potter (Physical)");
        System.out.println("  - Lord of the Rings (Historical)");
        System.out.println("  - Clean Code (EBook)");
        System.out.println("  - Design Patterns (from external catalog via Adapter)");

        System.out.println("\n--- John walks in ---");
        User john = new User("John", true, true);

        BookInterface hp = library.findBook("Harry Potter");
        BookInterface premiumHP = new PremiumBook(hp);
        new BorrowRequestFacade(john, premiumHP, hpObserver).borrow();

        System.out.println("\n--- Sara walks in ---");
        User sara = new User("Sara", true, true);
        PremiumProxyAccessEbooks ebook = new PremiumProxyAccessEbooks("Clean Code", ccObserver, sara);
        ebook.borrowBook();

        System.out.println("\n--- Ali walks in ---");
        User ali = new User("Ali", false, true);
        PremiumProxyAccessEbooks ebookForAli = new PremiumProxyAccessEbooks("Clean Code", ccObserver, ali);
        ebookForAli.borrowBook();

        System.out.println("\n--- Unregistered person tries to borrow ---");
        User ghost = new User("Ghost", false, false);
        new BorrowRequestFacade(ghost, hp, hpObserver).borrow();

        System.out.println("\n--- Mona and Karim want Harry Potter ---");
        User mona  = new User("Mona", false, true);
        User karim = new User("Karim", true, true);
        new BorrowRequestFacade(mona,  hp, hpObserver).borrow();
        new BorrowRequestFacade(karim, hp, hpObserver).borrow();

        System.out.println("\n--- John returns Harry Potter ---");
        library.returnBook("Harry Potter", john);

        System.out.println("\nMona's inbox:  " + mona.getNotifications());
        System.out.println("Karim's inbox: " + karim.getNotifications());
    }
}
