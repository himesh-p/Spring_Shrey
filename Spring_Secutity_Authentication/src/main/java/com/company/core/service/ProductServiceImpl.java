package com.company.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.core.entity.ProductEntity;
import com.company.core.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
	 
	private final ProductRepository repository;

	@Override
	public ProductEntity save(ProductEntity entity) {
		return repository.save(entity);
	}

	@Override
	public List<ProductEntity> getAll() {
		return repository.findAll();
	}

	@Override
	public ProductEntity getById(Long id) {   // Here we can use Optional class for better utilization and we don't use orElseThrow function....
		return repository.findById(id).orElseThrow();
	}	
}