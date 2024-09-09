package com.example.my_book_management_system.repository;

import com.example.my_book_management_system.entity.AuthorEntity;
import com.example.my_book_management_system.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    // Retrieve a list of all genres.
    Page<AuthorEntity> findAll(Pageable pageable);
}
