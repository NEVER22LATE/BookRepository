package com.example.library.demo.controller;

import com.example.library.demo.repositories.BookRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

//    @RequestMapping("/")
//    public String home() {
//        return "New application";
//    }
    @RequestMapping("books")
    public String getBooks(Model model){

        model.addAttribute("books", bookRepository.findAll());

        return "list";
    }
}