package mk.ukim.finki.emtlab.service.impl;


import mk.ukim.finki.emtlab.model.Author;
import mk.ukim.finki.emtlab.model.Country;
import mk.ukim.finki.emtlab.repository.AuthorRepository;
import mk.ukim.finki.emtlab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> save(String name, String surname, Country country) {
        return Optional.of(this.authorRepository.save(new Author(name, surname, country)));
    }
}
