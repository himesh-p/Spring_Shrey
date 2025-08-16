package com.ordersystem.orderservice.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvantoryItem {
	@Id
	private String id;
	
	private String product;
	
	private int quntity;
}