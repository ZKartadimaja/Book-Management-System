package com.example.my_book_management_system.service.impl;

import com.example.my_book_management_system.Request.BookRequest;
import com.example.my_book_management_system.entity.AuthorEntity;
import com.example.my_book_management_system.entity.BookEntity;
import com.example.my_book_management_system.entity.GenreEntity;
import com.example.my_book_management_system.repository.AuthorRepository;
import com.example.my_book_management_system.repository.BookRepository;
import com.example.my_book_management_system.repository.GenreRepository;
import com.example.my_book_management_system.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GenreRepository genreRepository;

    public BookEntity saveBook(BookRequest book){
        AuthorEntity author = authorRepository.findById(book.getAuthorId()).orElse(null);
        GenreEntity genre = genreRepository.findById(book.getGenreId()).orElse(null);
        System.out.println(author);
        System.out.println(genre);
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(book.getTitle());
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setAuthorId(author);
        bookEntity.setGenreId(genre);
        bookEntity.setPublishedDate(book.getPublishedDate());
        return bookRepository.save(bookEntity);
    }

    public Page<BookEntity> getAllBook(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

    public BookEntity getBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public BookEntity getBookByTitleOrAuthorOrGenre(String title, String author, String genre){
        return bookRepository.findByTitleOrAuthorOrGenre(title, author, genre);
    }

    public BookEntity updateBook(BookEntity book, BookRequest bookDetails){
        AuthorEntity author = authorRepository.findById(bookDetails.getAuthorId()).orElse(null);
        GenreEntity genre = genreRepository.findById(bookDetails.getGenreId()).orElse(null);
        System.out.println(author);
        System.out.println(genre);
        book.setTitle(bookDetails.getTitle());
        book.setIsbn(bookDetails.getIsbn());
        book.setAuthorId(author);
        book.setGenreId(genre);
        book.setPublishedDate(book.getPublishedDate());
        return bookRepository.save(book);
    }
}
