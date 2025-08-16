package com.company.core.service;


import java.util.List;

import com.company.core.dto.UserRequestDTO;
import com.company.core.dto.UserResponseDTO;

public interface UserService {
	UserResponseDTO saveUser(UserRequestDTO requestDTO);
	List<UserResponseDTO> getAllUsers();
	UserResponseDTO getById(Long id);
	UserResponseDTO getByUsername(String username);
	UserResponseDTO getByEmail(String email);
	void deleteById(Long id);
}