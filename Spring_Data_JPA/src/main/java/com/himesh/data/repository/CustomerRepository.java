package com.himesh.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.himesh.data.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
//
}
