package com.himesh.data.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.himesh.data.dto.UserRequestDTO;
import com.himesh.data.dto.UserResponceDTO;

public interface UserService {
	UserResponceDTO createUser(UserRequestDTO dto , MultipartFile image) throws IOException;
	List<UserResponceDTO> getAllUsers();
	UserResponceDTO getUserById(Long id);
	UserResponceDTO updateUser(Long id , UserRequestDTO dto , MultipartFile image) throws IOException;
	void deleteById(Long id);
}