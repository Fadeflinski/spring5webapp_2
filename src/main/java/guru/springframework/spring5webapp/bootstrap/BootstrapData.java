package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData  implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        authorRepository.save(eric);
        Author rod = new Author("Rod", "Johnson");
        authorRepository.save(rod);

        Book ddd = new Book("Domain Driven Design", "978-0321125217");
        bookRepository.save(ddd);
        Book noEJB = new Book("JEE Development without EJB", "978-0764558313");
        bookRepository.save(noEJB);

        eric.getBooks().add(ddd);
        ddd.getAutors().add(eric);

        rod.getBooks().add(noEJB);
        noEJB.getAutors().add(rod);

        Publisher addWes = new Publisher("Addison-Wesley", "Route 66", "Boston", "MA", "02101");
        publisherRepository.save(addWes);

        System.out.println("Started  in Bootstrap");
        System.out.println("Number of Books=" + bookRepository.count());
        System.out.println("Number of Authors=" + authorRepository.count());
        System.out.println("Number of Publishers=" + publisherRepository.count());
    }
}
