package com.example.my_book_management_system.service;

import com.example.my_book_management_system.entity.GenreEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GenreService {
    GenreEntity saveGenre(GenreEntity genre);

    List<GenreEntity> getAllGenre();

    GenreEntity getGenreById(Long id);

    GenreEntity deleteGenre(GenreEntity genre);
}
