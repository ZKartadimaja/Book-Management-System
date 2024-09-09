package com.example.my_book_management_system.repository;

import com.example.my_book_management_system.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    // Get Book By Title
    Optional<BookEntity> findByTitle(String title);
//    Optional<BookEntity> findByTitleIgnoreCase(String title);

    // Retrieve a list of all genres.
    Page<BookEntity> findAll(Pageable pageable);


}
