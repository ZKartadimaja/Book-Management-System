package com.example.my_book_management_system.service;

import com.example.my_book_management_system.entity.AuthorEntity;
import com.example.my_book_management_system.entity.GenreEntity;

import java.util.List;

public interface AuthorService {
    List<AuthorEntity> getAllAuthor();

    AuthorEntity getAuthorById(Long id);

    AuthorEntity deleteAuthor(AuthorEntity author);

    AuthorEntity saveAuthor(AuthorEntity author);
}
