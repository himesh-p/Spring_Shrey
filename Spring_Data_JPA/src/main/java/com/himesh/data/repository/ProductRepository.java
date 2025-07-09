package com.himesh.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.himesh.data.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
//
}