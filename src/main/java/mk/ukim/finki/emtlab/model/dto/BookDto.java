package mk.ukim.finki.emtlab.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emtlab.model.enumerations.BookCategory;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
public class BookDto {
    private String name;

    @Enumerated(EnumType.STRING)
    private BookCategory category;

    private Integer availableCopies;

    public BookDto(String name, BookCategory category, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
    }
}
