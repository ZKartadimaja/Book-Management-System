package com.example.my_book_management_system.Request;

import com.example.my_book_management_system.entity.AuthorEntity;
import com.example.my_book_management_system.entity.GenreEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

    @JsonProperty("title")
    private String title;

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("author_id")
    private Long authorId;

    @JsonProperty("genre_id")
    private Long genreId;

    @JsonProperty("published_date")
    private String publishedDate;
}
