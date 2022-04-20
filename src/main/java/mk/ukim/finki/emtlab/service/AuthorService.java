package mk.ukim.finki.emtlab.service;


import mk.ukim.finki.emtlab.model.Author;
import mk.ukim.finki.emtlab.model.Country;

import java.util.Optional;

public interface AuthorService {
    Optional<Author> save(String name, String surname, Country country);
}
