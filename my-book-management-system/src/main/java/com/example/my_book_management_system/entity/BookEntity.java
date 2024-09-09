package com.example.my_book_management_system.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "books")
@Setter
@Getter
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @JsonProperty("title")
    private String title;

    @Column(nullable = false, length = 100)
    @JsonProperty("isbn")
    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(nullable = false, length = 100)
    @JsonProperty("author")
    private String author;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(nullable = false, length = 100)
    @JsonProperty("genre")
    private String genre;

    @Column(name = "published_date", nullable = false)
    private Date publishedDate;



}
