package guru.springframework.spring5webapp.controller;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class BookController {

    BookRepository bookRepository ;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books",bookRepository.findAll());

        return  "books";
    }
}
