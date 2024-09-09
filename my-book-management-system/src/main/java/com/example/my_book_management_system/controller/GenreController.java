package com.example.my_book_management_system.controller;

import com.example.my_book_management_system.entity.GenreEntity;
import com.example.my_book_management_system.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<GenreEntity> getAllEmployees() {
        return genreService.getAllGenre();
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
    public ResponseEntity<GenreEntity> updateEmployee(@PathVariable Long id, @RequestBody GenreEntity genreDetails) {
        GenreEntity genre = genreService.getGenreById(id);
        if (genre != null) {
            genre.setFirstName(genreDetails.getFirstName());
            genre.setLastName(genreDetails.getLastName());
            genre.setHireDate(genreDetails.getHireDate());
            GenreEntity updatedGenre = genreService.saveGenre(genre);
            return ResponseEntity.ok(updatedGenre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
