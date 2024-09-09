package com.example.my_book_management_system.controller;

import com.example.my_book_management_system.entity.GenreEntity;
import com.example.my_book_management_system.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping
    public GenreEntity createGenre(@RequestBody GenreEntity genre) {
        return genreService.saveGenre(genre);
    }

    @GetMapping()
    public ResponseEntity<Page<GenreEntity>> getAllGenres(Pageable pageable) {
        Page<GenreEntity> genre = genreService.getAllGenre(pageable);
        return ResponseEntity.ok(genre);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreEntity> getGenreById(@PathVariable Long id) {
        GenreEntity genre = genreService.getGenreById(id);
        if (genre != null) {
            return ResponseEntity.ok(genre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreEntity> updateGenre(@PathVariable Long id, @RequestBody GenreEntity genreDetails) {
        GenreEntity genre = genreService.getGenreById(id);
        if (genre != null) {
            genre.setName(genreDetails.getName());
            GenreEntity updatedGenre = genreService.saveGenre(genre);
            return ResponseEntity.ok(updatedGenre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenreEntity> deleteGenre(@PathVariable Long id){
        GenreEntity genre = genreService.getGenreById(id);
        if (genre != null) {
            genreService.deleteGenre(id);
            return ResponseEntity.ok(genre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
