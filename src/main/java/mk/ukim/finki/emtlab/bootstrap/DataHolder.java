package mk.ukim.finki.emtlab.bootstrap;

import lombok.Getter;

import mk.ukim.finki.emtlab.model.enumerations.BookCategory;
import mk.ukim.finki.emtlab.service.AuthorService;
import mk.ukim.finki.emtlab.service.BookService;
import mk.ukim.finki.emtlab.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Getter
public class DataHolder {
    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public DataHolder(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }
    private BookCategory randomizeEventType(int i) {
        if (i % 3 == 0) return BookCategory.CLASSICS;
        else if (i % 3 == 1) return BookCategory.FANTASY;
        return BookCategory.BIOGRAPHY;
    }

    @PostConstruct
    public void init() {
        for (int i = 1; i < 20; i++) {
            this.bookService.save("Book: " + i, randomizeEventType(i), 20 * i);
        }
        for (int i = 1; i < 3; i++) {
            this.countryService.save("Country: " + i, "Europe");
        }
        for (int i = 3; i < 6; i++) {
            this.countryService.save("Country: " + i, "Asia");
        }
        for (int i = 1; i < 5; i++) {
            this.authorService.save("Author name: " + i, "Author Surname " + i, this.countryService.findAll().get((i - 1) % 5));
        }
    }
}

