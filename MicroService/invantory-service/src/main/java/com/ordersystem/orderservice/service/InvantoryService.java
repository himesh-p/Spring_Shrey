package com.ordersystem.orderservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ordersystem.orderservice.model.InvantoryItem;
import com.ordersystem.orderservice.repository.InvantoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InvantoryService {
	
	private final InvantoryRepository repository;
	
	public List<InvantoryItem> getAllInvantories(){
		return repository.findAll();
	}
	
	public InvantoryItem getInvantoryById(String id) {
		return repository.findById(id).orElse(null);
	}
	
	public InvantoryItem createInvantory(InvantoryItem item) {
		return repository.save(item);
	}
	
	public void deleteInvantory(String id) {
		repository.deleteById(id);
	}
}