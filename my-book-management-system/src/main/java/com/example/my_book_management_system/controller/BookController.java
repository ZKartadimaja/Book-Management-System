package com.example.my_book_management_system.controller;

import com.example.my_book_management_system.entity.BookEntity;
import com.example.my_book_management_system.entity.GenreEntity;
import com.example.my_book_management_system.service.BookService;
import com.example.my_book_management_system.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public BookEntity createBook(@RequestBody BookEntity book) {
        return bookService.saveBook(book);
    }

    @GetMapping()
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBook();
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

    @GetMapping("/api/books/search")
    public ResponseEntity<BookEntity> getBookByAuthor(@PathVariable Long id) {
        BookEntity book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookEntity> updateBook(@PathVariable Long id, @RequestBody BookEntity bookDetails) {
        BookEntity book = bookService.getBookById(id);
        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            book.setIsbn(bookDetails.getIsbn());
            book.setAuthorId(bookDetails.getAuthorId());
            book.setGenreId(bookDetails.getGenreId());
            BookEntity updatedBook = bookService.saveBook(book);
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
