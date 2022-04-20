package mk.ukim.finki.emtlab.service;

import mk.ukim.finki.emtlab.model.Book;
import mk.ukim.finki.emtlab.model.dto.BookDto;
import mk.ukim.finki.emtlab.model.enumerations.BookCategory;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(String name, BookCategory category, Integer availableCopies);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id,String name, BookCategory category, Integer availableCopies);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);

    Book markAsTaken(Long id);
}
