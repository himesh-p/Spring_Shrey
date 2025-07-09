package com.himesh.data.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TrainEntity {
	@PositiveOrZero(message = "ID must be zero or positive")
	private int id;
	
	@NotBlank(message = "Train name must not be blank")
	@Size(max = 255, message = "Train name must be at most 255 characters")
	private String name;
	
	@NotBlank(message = "Origin must not be blank")
	@Size(max = 255, message = "Origin must be at most 255 characters")
	private String origin;
	
	@NotBlank(message = "Destination must not be blank")
	@Size(max = 255, message = "Destination must be at most 255 characters")
	private String destination;
}