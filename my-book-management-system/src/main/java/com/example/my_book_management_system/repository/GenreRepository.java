package com.example.my_book_management_system.repository;

import com.example.my_book_management_system.entity.GenreEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
    //Get details of a specific genre
    Optional<GenreEntity> findByName(String name);

    Optional<GenreEntity> findByNameIgnoreCase(String name);

    // Retrieve a list of all genres.
    Page<GenreEntity> findAll(Pageable name);

}
