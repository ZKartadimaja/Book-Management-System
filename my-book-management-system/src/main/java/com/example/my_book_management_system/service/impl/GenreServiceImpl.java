package com.example.my_book_management_system.service.impl;

import com.example.my_book_management_system.entity.GenreEntity;
import com.example.my_book_management_system.repository.GenreRepository;
import com.example.my_book_management_system.service.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public GenreEntity saveGenre(GenreEntity genre){
        return genreRepository.save(genre);
    }

    public List<GenreEntity> getAllGenre(){
        return genreRepository.findAll();
    }

    public GenreEntity getGenreById(Long id){
        return genreRepository.findById(id).orElse(null);
    }

    public void deleteGenre(Long id){
        genreRepository.deleteById(id);
    }
}
