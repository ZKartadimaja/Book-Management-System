package com.example.my_book_management_system.service;

import com.example.my_book_management_system.entity.AuthorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public interface AuthorService {
    Page<AuthorEntity> getAllAuthor(Pageable pageable);

    AuthorEntity getAuthorById(Long id);

    void deleteAuthor(Long id);

    AuthorEntity saveAuthor(AuthorEntity author);
}
