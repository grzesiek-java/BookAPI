package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.MockBookService;

import java.util.List;

@RestController
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
    @RequestMapping("")
    public List<Book> showBooks(MockBookService service){
        return service.getList();
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        service.add(book);
    }

    @DeleteMapping ("/{id}")
    public void removeBook(@PathVariable Long id){
        service.removeBook(id);
    }

    }

