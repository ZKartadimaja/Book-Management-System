package com.example.my_book_management_system.service;

import com.example.my_book_management_system.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public interface BookService {
    BookEntity saveBook(BookEntity book);

    Page<BookEntity> getAllBook(Pageable pageable);

    BookEntity getBookById(Long id);

    void deleteBook(Long id);

    BookEntity getBookByTitle(String title);
}
