package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.model.Book;
import pl.coderslab.service.MockBookService;

import java.util.List;

@RestController
@Component
@RequestMapping("/books")
public class BookController {
    private final MockBookService service;

    @Autowired
    public BookController(MockBookService service) {
        this.service = service;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }
    @RequestMapping("/list")
    public List<Book> showBooks(MockBookService service){
        return service.getList();
    }
    @RequestMapping("/delete/")
    public List<Book> removeBook(MockBookService service){
        return service.getList();
    }

    }

