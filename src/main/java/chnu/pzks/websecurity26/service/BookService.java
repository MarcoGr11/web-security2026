/*
 * Author: MarcoGr11
 * Email: babunbogdan@gmail.com
 * Created: 21.09.2026
 * Course: Spring Security
 * Task №1. Simple web-application
 */

package chnu.pzks.websecurity26.service;

import chnu.pzks.websecurity26.model.Book;
import chnu.pzks.websecurity26.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @PostConstruct
    public void init() {
        bookRepository.deleteAll();
        bookRepository.saveAll(List.of(
                new Book("1", "Kobzar", "Collection of poems", "Taras Shevchenko", 1840),
                new Book("2", "Forest Song", "Drama-fairy tale", "Lesya Ukrainka", 1911),
                new Book("3", "Shadows of Forgotten Ancestors", "Novella about Hutsul life", "Mykhailo Kotsiubynsky", 1911)
        ));
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(String id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found: " + id));
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(String id, Book book) {
        Book existing = getBook(id);
        existing.setName(book.getName());
        existing.setDescription(book.getDescription());
        existing.setAuthor(book.getAuthor());
        existing.setYear(book.getYear());
        return bookRepository.save(existing);
    }

    public void deleteBook(String id) {
        getBook(id);
        bookRepository.deleteById(id);
    }
}
