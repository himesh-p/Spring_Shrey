package com.example.RestApiPostman.service;

import com.example.RestApiPostman.entity.AuthorEntity;
import com.example.RestApiPostman.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<AuthorEntity> getAllBooks(){
        return repository.findAll();
    }

    public Optional<AuthorEntity> getById(Long id){
        return repository.findById(id);
    }

    public AuthorEntity saveBook(AuthorEntity entity){
        return repository.save(entity);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}