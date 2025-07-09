package com.himesh.data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.himesh.data.entity.Order;
import com.himesh.data.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	
	private final OrderRepository orderRepository;

	@Override
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}

	@Override
	public Optional<Order> getOrderById(Long id){
		return orderRepository.findById(id);
	}

	@Override
	public Order saveOrder(Order order){
		return orderRepository.save(order);
	}

	@Override
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}
}
