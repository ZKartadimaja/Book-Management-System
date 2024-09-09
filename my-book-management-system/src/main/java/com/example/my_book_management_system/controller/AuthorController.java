package com.example.my_book_management_system.controller;

import com.example.my_book_management_system.entity.AuthorEntity;
import com.example.my_book_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public AuthorEntity createAuthor(@RequestBody AuthorEntity author) {
        return authorService.saveAuthor(author);
    }

    @GetMapping()
    public List<AuthorEntity> getAllAuthors() {
        return authorService.getAllAuthor();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorEntity> getAuthorById(@PathVariable Long id) {
        AuthorEntity author = authorService.getAuthorById(id);
        if (author != null) {
            return ResponseEntity.ok(author);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorEntity> updateAuthor(@PathVariable Long id, @RequestBody AuthorEntity authorDetails) {
        AuthorEntity author = authorService.getAuthorById(id);
        if (author != null) {
            author.setName(authorDetails.getName());
            author.setBio(authorDetails.getBio());
            AuthorEntity updatedAuthor = authorService.saveAuthor(author);
            return ResponseEntity.ok(updatedAuthor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AuthorEntity> deleteAuthor(@PathVariable Long id){
        AuthorEntity author = authorService.getAuthorById(id);
        if (author != null) {
            authorService.deleteAuthor(id);
            return ResponseEntity.ok(author);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

