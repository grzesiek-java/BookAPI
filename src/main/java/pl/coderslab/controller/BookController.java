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
    public List<Book> showBooks(){
        return service.showBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        service.addBook(book);
    }
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id){
        return service.getBookById(id).orElseThrow(()->new RuntimeException("book not found"));
    }
    @PutMapping("")
    @ResponseBody
    public void update(@RequestBody Book book){
        service.updateBook(book);
    }

    @DeleteMapping ("/{id}")
    public void removeBook(@PathVariable Long id){
        service.removeBook(id);
    }

    }

