package com.example.my_book_management_system.service.impl;

import com.example.my_book_management_system.entity.AuthorEntity;
import com.example.my_book_management_system.repository.AuthorRepository;
import com.example.my_book_management_system.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorEntity> getAllAuthor(){
        return authorRepository.findAll();
    }

    public AuthorEntity getAuthorById(Long id){
        return authorRepository.findById(id).orElse(null);
    }

    public void deleteAuthor(Long id){
        authorRepository.deleteById(id);
    }

    public AuthorEntity saveAuthor(AuthorEntity author){
        return authorRepository.save(author);
    }
}
