package com.example.my_book_management_system.service;

import com.example.my_book_management_system.entity.BookEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookService {
    BookEntity saveBook(BookEntity book);

    List<BookEntity> getAllBook();

    BookEntity getBookById(Long id);

    BookEntity deleteBook(BookEntity book);
}
