package com.himesh.core.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.himesh.core.entity.Product;

@Repository
public class ProductRepository {
	private final Map<Integer , Product> productDB = new HashMap<>();
	private int currentId = 1;
	
	public List<Product> findAll(){
		return new ArrayList<>(productDB.values());
	}
	
	public Product findById(int id){
		return productDB.get(id);
	}
	
	public void save(Product product) {
		if(product.getId() == 0){
			product.setId(currentId++);
		} 
		productDB.put(product.getId(), product);
	}
	
	public void delete(int id){
		productDB.remove(id);
	}
} 
