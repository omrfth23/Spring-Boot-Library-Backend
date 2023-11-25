package com.omrfth.librarydemo.repository;

import com.omrfth.librarydemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
