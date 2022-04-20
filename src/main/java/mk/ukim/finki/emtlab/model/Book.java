package mk.ukim.finki.emtlab.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emtlab.model.enumerations.BookCategory;


import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private BookCategory category;

    private Integer availableCopies;

    public Book(String name, BookCategory category, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
    }
}
