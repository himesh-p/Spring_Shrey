package com.himesh.data.service;

import java.util.List;
import java.util.Optional;

import com.himesh.data.entity.Order;

public interface OrderService {
	List<Order> getAllOrders();
	Optional<Order> getOrderById(Long id);
	Order saveOrder(Order order);
	void deleteOrder(Long id);
}