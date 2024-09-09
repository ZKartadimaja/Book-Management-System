package com.example.my_book_management_system.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "authors")
@Setter
@Getter
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 100)
    @JsonProperty("name")
    private String name;

    @Column(nullable = false, length = 100)
    @JsonProperty("bio")
    private String bio;
}
