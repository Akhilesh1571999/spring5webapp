package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG publishing");
        publisher.setCity("st petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("publisher count >>"+ publisherRepository.count());

        Author eric = new Author("eric","evans");
        Book ddd = new Book("Domain driven design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);


        Author james = new Author("james","jhonson");
        Book noEJb = new Book("J2EE development", "123546");
        james.getBooks().add(noEJb);
        noEJb.getAuthors().add(james);

        noEJb.setPublisher(publisher);
        publisher.getBooks().add(noEJb);

        authorRepository.save(james);
        bookRepository.save(noEJb);
        publisherRepository.save(publisher);

        System.out.println("Number of books >> " + bookRepository.count());
        System.out.println("publisher number of book >> "+ publisher.getBooks().size());
    }
}
