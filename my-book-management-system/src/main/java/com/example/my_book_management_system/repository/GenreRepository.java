package com.example.my_book_management_system.repository;

import com.example.my_book_management_system.entity.GenreEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
    // Retrieve a list of all genres.
    Page<GenreEntity> findAll(Pageable pageable);
}
