package com.example.my_book_management_system.service.impl;

import com.example.my_book_management_system.entity.BookEntity;
import com.example.my_book_management_system.repository.BookRepository;
import com.example.my_book_management_system.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookEntity saveBook(BookEntity book){
        return bookRepository.save(book);
    }

    public List<BookEntity> getAllBook(){
        return bookRepository.findAll();
    }

    public BookEntity getBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
