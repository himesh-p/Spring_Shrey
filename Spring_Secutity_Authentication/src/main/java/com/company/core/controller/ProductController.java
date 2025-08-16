package com.company.core.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.core.entity.ProductEntity;
import com.company.core.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
	
	private final ProductService service;
	
	@PostMapping()
	public ProductEntity add(@RequestBody ProductEntity entity) {
		return service.save(entity);
	}
	
	@GetMapping()
	public List<ProductEntity> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public ProductEntity getById(@PathVariable Long id) {
		return service.getById(id);
	}
}