package com.example.RestApiPostman.controller;

import com.example.RestApiPostman.entity.BookEntity;
import com.example.RestApiPostman.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    public List<BookEntity> home(){
        return service.getAllBooks();
    }

    public Optional<BookEntity> getBook(Long id) {
        return service.getById(id);
    }

    public BookEntity createBook(BookEntity entity){
        return service.saveBook(entity);
    }

    public void delete(Long id){
        service.deleteById(id);
    }
}
