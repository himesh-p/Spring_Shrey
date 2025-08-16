package com.company.core.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDTO {
	@NotNull(message = "Username is mandatory")
	private String username;
	
	@Email
	private String email;
	
	@Size(min = 8 , message = "Password length > 8")
	private String password;
}