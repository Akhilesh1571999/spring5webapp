package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("eric","evans");
        Book ddd = new Book("Domain driven design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author james = new Author("james","jhonson");
        Book noEJb = new Book("J2EE development", "123546");
        james.getBooks().add(noEJb);
        noEJb.getAuthors().add(james);

        authorRepository.save(james);
        bookRepository.save(noEJb);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books >> " + bookRepository.count());

    }
}
