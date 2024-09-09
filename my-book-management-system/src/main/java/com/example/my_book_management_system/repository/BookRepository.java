package com.example.my_book_management_system.repository;

import com.example.my_book_management_system.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository {
    Optional<BookEntity> findByBookName(String name);

    Optional<BookEntity> findByBookNameIgnoreCase(String name);

    // Retrieve a list of all genres.
    Page<BookEntity> findAll(Pageable name);
}
