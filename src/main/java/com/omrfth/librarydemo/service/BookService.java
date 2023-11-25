package com.omrfth.librarydemo.service;

import com.omrfth.librarydemo.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book getBookById(int id);

    Book saveBook(Book book);

    Book updateBook(Book book);

    void deleteBookById(int id);
}
