package mk.ukim.finki.emtlab.service.impl;

import mk.ukim.finki.emtlab.model.Book;
import mk.ukim.finki.emtlab.model.dto.BookDto;
import mk.ukim.finki.emtlab.model.enumerations.BookCategory;
import mk.ukim.finki.emtlab.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emtlab.repository.BookRepository;
import mk.ukim.finki.emtlab.service.BookService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(String name, BookCategory category, Integer availableCopies) {
        return Optional.of(this.bookRepository.save(new Book(name, category, availableCopies)));
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        return Optional.of(this.bookRepository.save(new Book(bookDto.getName(), bookDto.getCategory(), bookDto.getAvailableCopies())));
    }

    @Override
    public Optional<Book> edit(Long id, String name, BookCategory category, Integer availableCopies) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        book.setName(name);
        book.setCategory(category);
        book.setAvailableCopies(availableCopies);

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Book markAsTaken(Long id) {
        Book book=this.findById(id).orElseThrow(()->new BookNotFoundException(id));
        book.setAvailableCopies(book.getAvailableCopies()-1);
        if(book.getAvailableCopies()==0){
            this.deleteById(id);
            return book;
        }
        return bookRepository.save(book);
    }
}
