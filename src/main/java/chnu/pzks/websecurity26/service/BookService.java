package chnu.pzks.websecurity26.service;

import chnu.pzks.websecurity26.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    {
        books.add(new Book("1", "Kobzar", "Collection of poems", "Taras Shevchenko", 1840));
        books.add(new Book("2", "Forest Song", "Drama-fairy tale", "Lesya Ukrainka", 1911));
        books.add(new Book("3", "Shadows of Forgotten Ancestors", "Novella about Hutsul life", "Mykhailo Kotsiubynsky", 1911));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBook(String id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found: " + id));
    }

    public Book createBook(Book book) {
        books.add(book);
        return book;
    }

    public Book updateBook(String id, Book book) {
        Book existing = getBook(id);
        existing.setName(book.getName());
        existing.setDescription(book.getDescription());
        existing.setAuthor(book.getAuthor());
        existing.setYear(book.getYear());
        return existing;
    }

    public void deleteBook(String id) {
        books.remove(getBook(id));
    }
}
