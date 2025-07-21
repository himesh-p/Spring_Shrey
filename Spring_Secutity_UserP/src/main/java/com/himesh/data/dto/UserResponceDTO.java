package com.himesh.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponceDTO {
	private Long id; 
	private String name;
	private String email;
	private String profileImageUrl;
}