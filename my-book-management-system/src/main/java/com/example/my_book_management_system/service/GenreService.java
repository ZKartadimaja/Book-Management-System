package com.example.my_book_management_system.service;

import com.example.my_book_management_system.entity.GenreEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GenreService {
    GenreEntity saveGenre(GenreEntity genre);

    Page<GenreEntity> getAllGenre(Pageable pageable);

    GenreEntity getGenreById(Long id);

    void deleteGenre(Long id);
}
