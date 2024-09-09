package com.example.my_book_management_system.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "book")
@Setter
@Getter
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonProperty("title")
    private String title;

    @Column(nullable = false)
    @JsonProperty("isbn")
    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName ="id", nullable = false)
    @JsonProperty("author_id")
    private AuthorEntity authorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", referencedColumnName ="id", nullable = false)
    @JsonProperty("genre_id")
    private GenreEntity genreId;

    @Column(name = "published_date")
    private String publishedDate;
}
