package com.omrfth.librarydemo.model;


import jakarta.persistence.*;
import lombok.Data;

@Table(name = "book")
@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "author")
    private String authorName;

    @Column(name = "publisher")
    private String publisherName;


}
