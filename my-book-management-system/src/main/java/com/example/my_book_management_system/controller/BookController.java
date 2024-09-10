package com.example.my_book_management_system.controller;

import com.example.my_book_management_system.Request.BookRequest;
import com.example.my_book_management_system.entity.BookEntity;
import com.example.my_book_management_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public BookEntity createBook(@RequestBody BookRequest book) {
        return bookService.saveBook(book);
    }

    @GetMapping()
    public ResponseEntity<Page<BookEntity>> getAllBooks(Pageable pageable) {
        Page<BookEntity> book = bookService.getAllBook(pageable);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> getBookById(@PathVariable Long id) {
        BookEntity book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<BookEntity> getBookByAuthor(
            @RequestParam (name = "title", required = false, defaultValue = "") String title,
            @RequestParam (name = "author", required = false, defaultValue = "") String author,
            @RequestParam (name = "genre", required = false, defaultValue = "") String genre
    ) { BookEntity book = bookService.getBookByTitleOrAuthorOrGenre(title, author, genre);

        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookEntity> updateBook(@PathVariable Long id, @RequestBody BookRequest bookDetails) {
        BookEntity book = bookService.getBookById(id);
        if (book != null) {
            BookEntity updatedBook = bookService.updateBook(book, bookDetails);
            return ResponseEntity.ok(updatedBook);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookEntity> deleteBook(@PathVariable Long id){
        BookEntity book = bookService.getBookById(id);
        if (book != null) {
            bookService.deleteBook(id);
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
