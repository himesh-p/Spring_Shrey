package com.company.rest.controller;

import com.company.rest.entity.Aeroplane;
import com.company.rest.service.AeroplaneService;
import com.company.rest.util.AeroplaneStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aeroplanes")
public class AeroplaneController {

    private final AeroplaneService service;

    public AeroplaneController(AeroplaneService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aeroplane> listAeroplane(){
        return service.getAllAeroplane();
    }

    @PostMapping
    public Aeroplane createAeroplane(@RequestBody Aeroplane aeroplane) {
        return service.create(aeroplane);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aeroplane> getById(@PathVariable Long id){
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aeroplane> update(@PathVariable Long id, @RequestBody Aeroplane updated) {
        try {
            return ResponseEntity.ok(service.update(id, updated));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAeroplane(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Aeroplane>> getByStatus(@PathVariable AeroplaneStatus status){
        try{
            return ResponseEntity.ok(service.getByStatus(status));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}