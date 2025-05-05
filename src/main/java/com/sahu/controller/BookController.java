package com.sahu.controller;

import com.sahu.model.Book;
import com.sahu.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BookController {


    private final BookRepository bookRepo;

    @GetMapping("/")
    public String displayForm(Model model) {
        log.info("*** displayForm () method execution start ***");
        Book bookObj = new Book();
        model.addAttribute("book", bookObj);

        List<Book> booksList = bookRepo.findAll();
        model.addAttribute("books", booksList);

        log.info("*** displayForm () method execution end ***");
        return "index";
    }

    @PostMapping("/")
    public String saveBook(Book book, Model model) {
        log.info("*** saveBook () method execution start ***");
        bookRepo.save(book);
        List<Book> booksList = bookRepo.findAll();
        model.addAttribute("books", booksList);

        Book bookObj = new Book();
        model.addAttribute("book", bookObj);


        model.addAttribute("msg", "Book Saved Successfully");
        log.info("*** saveBook () method execution end ***");
        return "index";
    }
}
