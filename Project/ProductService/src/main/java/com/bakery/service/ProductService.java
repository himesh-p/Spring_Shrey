package com.bakery.service;

import com.bakery.entities.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductsById(Long id);
    public Product addProduct(Product product);
    public void deleteProduct(Long id);
}