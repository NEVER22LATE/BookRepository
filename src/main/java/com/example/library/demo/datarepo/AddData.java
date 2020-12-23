package com.example.library.demo.datarepo;

import com.example.library.demo.domain.Author;
import com.example.library.demo.domain.Book;
import com.example.library.demo.domain.Publisher;
import com.example.library.demo.repositories.AuthorRepository;
import com.example.library.demo.repositories.BookRepository;
import com.example.library.demo.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AddData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public AddData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started add data here...");

        Publisher publisher = new Publisher();
        publisher.setName("Times India");
        publisher.setCity("Bangalore");
        publisher.setState("Karnataka");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author servesh = new Author("Servesh", "Kumar");
        Book ddd = new Book("Domain Driven Design", "123123");
        servesh.getBooks().add(ddd);
        ddd.getAuthors().add(servesh);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(servesh);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rahul = new Author("rahul", "Kumar");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rahul.getBooks().add(noEJB);
        noEJB.getAuthors().add(rahul);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rahul);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}
