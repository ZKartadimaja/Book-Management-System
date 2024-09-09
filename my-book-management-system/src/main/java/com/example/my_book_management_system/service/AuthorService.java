package com.example.my_book_management_system.service;

import com.example.my_book_management_system.entity.AuthorEntity;
import com.example.my_book_management_system.entity.GenreEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthorService {
    List<AuthorEntity> getAllAuthor();

    AuthorEntity getAuthorById(Long id);

    AuthorEntity deleteAuthor(AuthorEntity author);

    AuthorEntity saveAuthor(AuthorEntity author);
}
