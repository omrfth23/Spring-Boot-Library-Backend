package com.omrfth.librarydemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "member")
@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String memberName;

    @Column(name = "last_name")
    private String memberLastName;

    @Column(name = "email")
    private String memberEmail;
}
