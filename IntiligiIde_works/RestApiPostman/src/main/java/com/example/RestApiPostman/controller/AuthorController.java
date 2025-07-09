package com.example.RestApiPostman.controller;

import com.example.RestApiPostman.entity.AuthorEntity;
import com.example.RestApiPostman.service.AuthorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    public List<AuthorEntity> home(){
        return service.getAllBooks();
    }

    public Optional<AuthorEntity> getBook(Long id) {
        return service.getById(id);
    }

    public AuthorEntity createBook(AuthorEntity entity){
        return service.saveBook(entity);
    }

    public void delete(Long id){
        service.deleteById(id);
    }
}
