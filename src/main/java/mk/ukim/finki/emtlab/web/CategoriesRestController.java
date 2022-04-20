package mk.ukim.finki.emtlab.web;


import mk.ukim.finki.emtlab.model.enumerations.BookCategory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/categories")
public class CategoriesRestController {

    @GetMapping
    private List<BookCategory> getCategories(){
        return List.of(BookCategory.values());
    }
}
