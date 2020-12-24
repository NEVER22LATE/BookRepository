package com.example.library.demo.datarepo;

import com.example.library.demo.domain.Author;
import com.example.library.demo.domain.Book;
import com.example.library.demo.domain.Publisher;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddDataTest {

    // setting up and tearing down to the test..

    private Author author;
    private Book book;
    private Publisher publisher;

    @BeforeAll
    public void start() {
        System.out.println("Start testing..");
    }

    @BeforeEach
    public void init() {

        System.out.println("Test data initialization... Each time");
        author = new Author("servesh","kumar");
        book = new Book("First c++","1234");
        author.getBooks().add(book);
        book.getAuthors().add(author);
        publisher = new Publisher();
        book.setPublisher(publisher);
        publisher.getBooks().add(book);
        publisher.getBooks().add(book);
        publisher.setName("New York timies");
        publisher.setCity("Bangalore");
        publisher.setState("karnataka");
//        bookRepository.save(book);
//        assertEquals(bookRepository.count(), 1);
    }
    @Test
    public void addBook() {
        assertEquals(book.getAuthors().size(), 1);
    }
    @Test
    public  void addPublisher() {
        assertEquals(publisher.getBooks().size(), 1);
    }
    @Test
    public void addAuthor() {
        assertEquals(author.getBooks().size(), 1);
    }

    @AfterAll
    public void exit() {
        System.out.println("Testing finished..");
    }
}