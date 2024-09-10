package com.example.my_book_management_system.controller;

import com.example.my_book_management_system.entity.AuthorEntity;
import com.example.my_book_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<AuthorEntity>> getAllAuthors(Pageable pageable) {
        Page<AuthorEntity> author = authorService.getAllAuthor(pageable);
        return ResponseEntity.ok(author);
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

