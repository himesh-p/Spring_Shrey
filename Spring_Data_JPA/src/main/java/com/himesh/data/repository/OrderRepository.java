package com.himesh.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.himesh.data.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
//
}
