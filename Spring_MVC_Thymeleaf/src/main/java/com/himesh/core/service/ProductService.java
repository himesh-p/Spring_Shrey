package com.himesh.core.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.himesh.core.entity.Product;
import com.himesh.core.repository.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> getAll(){
		return productRepository.findAll();
	}
	
	public Product getById(int id){
		return productRepository.findById(id);
	}
	
	public void save(Product product){
		productRepository.save(product);
	}
	
	public void delete(int id){
		productRepository.delete(id);
	}
}
