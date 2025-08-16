package com.ordersystem.orderservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordersystem.orderservice.model.OrderModel;
import com.ordersystem.orderservice.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

	private final OrderService orderService;

	
	@GetMapping
	public List<OrderModel> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@GetMapping("/{id}")
	public OrderModel getById(@PathVariable Long id) {
		return orderService.getOrderById(id);
	}
	
	@PostMapping
	public OrderModel save(@RequestBody OrderModel model) {
		return orderService.createOrder(model);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOrderById(@PathVariable Long id){
		orderService.deleteOrder(id);
	}
}