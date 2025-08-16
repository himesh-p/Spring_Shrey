package com.ordersystem.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ordersystem.orderservice.model.OrderModel;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long>{
	//
}