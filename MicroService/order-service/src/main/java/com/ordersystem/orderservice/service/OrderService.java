package com.ordersystem.orderservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ordersystem.orderservice.model.OrderModel;
import com.ordersystem.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	 
	private final OrderRepository orderRepository;
	 
	public List<OrderModel> getAllOrders(){
		return orderRepository.findAll();
	}  
	
	public OrderModel getOrderById(Long id) {
		return orderRepository.findById(id).orElse(null);
	}
	
	public OrderModel createOrder(OrderModel model){
		return orderRepository.save(model);
	}
	
	public void deleteOrder(Long id){
		orderRepository.deleteById(id);
	}
}
