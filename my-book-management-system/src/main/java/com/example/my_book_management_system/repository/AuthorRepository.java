package com.example.my_book_management_system.repository;

import com.example.my_book_management_system.entity.AuthorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository {
    Optional<AuthorEntity> findByAuthorName(String name);

    Optional<AuthorEntity> findByAuthorNameIgnoreCase(String name);

    // Retrieve a list of all genres.
    Page<AuthorEntity> findAll(Pageable name);
}
