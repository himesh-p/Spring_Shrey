package com.example.RestApiPostman.service;

import com.example.RestApiPostman.entity.BookEntity;
import com.example.RestApiPostman.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<BookEntity> getAllBooks(){
        return repository.findAll();
    }

    public Optional<BookEntity> getById(Long id){
        return repository.findById(id);
    }

    public BookEntity saveBook(BookEntity entity){
        return repository.save(entity);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}