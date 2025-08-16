package com.company.core.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.company.core.dto.UserRequestDTO;
import com.company.core.dto.UserResponseDTO;
import com.company.core.entity.UserEntity;
import com.company.core.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public UserResponseDTO saveUser(UserRequestDTO requestDTO) {
		UserEntity user = mapToEntity(requestDTO);
		return mapToDTO(repository.save(user));
	}

	@Override
	public List<UserResponseDTO> getAllUsers() {
		return repository.findAll().stream()
				.map(this::mapToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public UserResponseDTO getById(Long id) {
		return repository.findById(id)
				.map(this::mapToDTO)
				.orElseThrow(()-> new RuntimeException("user with id(" + id + ") not found"));
	}

	@Override
	public UserResponseDTO getByUsername(String username) {
		return repository.findByUsername(username)
				.map(this::mapToDTO)
				.orElseThrow(() -> new RuntimeException("user with username("+username+") not found"));
	}

	@Override
	public UserResponseDTO getByEmail(String email) {
		return repository.findByEmail(email)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("user with email("+email+") not found"));
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public UserResponseDTO mapToDTO(UserEntity entity) {
		UserResponseDTO dto = new UserResponseDTO();
		dto.setId(entity.getId());
		dto.setUsername(entity.getUsername());
		dto.setEmail(entity.getEmail());
		return dto;
	}
	
	public UserEntity mapToEntity(UserRequestDTO dto) {
		UserEntity user = new UserEntity();
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		return user;
	}
	
}
