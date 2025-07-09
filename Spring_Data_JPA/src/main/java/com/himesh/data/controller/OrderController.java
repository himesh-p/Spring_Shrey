package com.himesh.data.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.himesh.data.entity.Customer;
import com.himesh.data.entity.Order;
import com.himesh.data.entity.Product;
import com.himesh.data.service.CustomerService;
import com.himesh.data.service.OrderService;
import com.himesh.data.service.ProductService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
	
	private final OrderService orderService;
	private final CustomerService customerService;
	private final ProductService productService;

	@GetMapping
	public String showOrders(Model model) {
		model.addAttribute("orders", orderService.getAllOrders());
		return "orders/list";
	}
	
	@GetMapping("create")
	public String showOrderForm(Model model) {
		model.addAttribute("order", new Order());
		model.addAttribute("customer", customerService.getAllCustomers());
		model.addAttribute("products", productService.getAllProducts());
		return "orders/form";
	}
	
	@PostMapping("create")
	public String createOrder(@ModelAttribute Order order , @RequestParam List<Long> productIds) {
		Customer customer = customerService.getCustomerById(order.getCustomer().getId()).orElseThrow();
		List<Product> product = productIds.stream()
				.map(productService::getProductById)
				.map(Optional::orElseThrow)
				.toList();
		order.setCustomer(customer);
		order.setProducts(product);
		order.setOrderDate(LocalDateTime.now());
		
		orderService.saveOrder(order);
		return "redirect:/orders";
	}
	
	@GetMapping("delete/{id}")
	public String deleteOrder(@PathVariable Long id) {
		orderService.deleteOrder(id);
		return "redirect:/orders";
	}
}
