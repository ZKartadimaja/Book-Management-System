package com.example.my_book_management_system.service.impl;

import com.example.my_book_management_system.entity.GenreEntity;
import com.example.my_book_management_system.repository.GenreRepository;
import com.example.my_book_management_system.service.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public GenreEntity saveGenre(GenreEntity genre){
        return genreRepository.save(genre);
    }

    public Page<GenreEntity> getAllGenre(Pageable pageable){
        return genreRepository.findAll(pageable);
    }

    public GenreEntity getGenreById(Long id){
        return genreRepository.findById(id).orElse(null);
    }

    public void deleteGenre(Long id){
        genreRepository.deleteById(id);
    }

    public GenreEntity updateGenre(GenreEntity genre, GenreEntity genreDetails){
        genre.setName(genreDetails.getName());
        return genreRepository.save(genre);
    }
}
