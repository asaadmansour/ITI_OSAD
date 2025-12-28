package functionalandstream;

import java.util.Arrays;

public class BookService {
    public Book[] filterBooksByAuthor(Author author, Book[] books) {
        return Arrays.stream(books)
            .filter(book-> Arrays.stream(book.getAuthors()).anyMatch(author::equals))
                .toArray(Book[]::new);
}

    public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
        return Arrays.stream(books).filter(book -> book.getPublisher().getId() == publisher.getId())
                        .toArray(Book[]::new);
    }
    public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
	return Arrays.stream(books).filter(book-> book.getPublishingYear() >= yearFromInclusively).toArray(Book[]::new);
    }
}