package com.company.core.service;

import java.util.List;

import com.company.core.entity.ProductEntity;

public interface ProductService {
	ProductEntity save(ProductEntity entity);
	List<ProductEntity> getAll();
	ProductEntity getById(Long id);
}