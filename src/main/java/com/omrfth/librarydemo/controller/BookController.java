package com.omrfth.librarydemo.controller;

import com.omrfth.librarydemo.model.Book;
import com.omrfth.librarydemo.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }

    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    @DeleteMapping("/books/{id}")
    public String deleteBookById(@PathVariable int id){
        bookService.deleteBookById(id);
        return "Book with id: " + id + " has been deleted.";
    }
}
