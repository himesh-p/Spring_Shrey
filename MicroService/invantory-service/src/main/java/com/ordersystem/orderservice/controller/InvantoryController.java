package com.ordersystem.orderservice.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordersystem.orderservice.model.InvantoryItem;
import com.ordersystem.orderservice.service.InvantoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/inventory")
public class InvantoryController {
	
	private final InvantoryService service;
	
	@GetMapping
	public List<InvantoryItem> getAll(){
		return service.getAllInvantories();
	}
	
	@GetMapping("/{id}")
	public InvantoryItem getById(String id) {
		return service.getInvantoryById(id);
	}
	
	@PostMapping
	public InvantoryItem create(@RequestBody InvantoryItem invantoryItem) {
		return service.createInvantory(invantoryItem);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable String id) {
		service.deleteInvantory(id);
	}
}
