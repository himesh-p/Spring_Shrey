package com.himesh.data.service;

import java.util.List;
import java.util.Optional;

import com.himesh.data.entity.Product;

public interface ProductService {
	List<Product> getAllProducts();
	Optional<Product> getProductById(Long id);
	Product saveProduct(Product product);
	void deleteProduct(Long id);
}