package com.himesh.data.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.himesh.data.dto.UserRequestDTO;
import com.himesh.data.dto.UserResponceDTO;
import com.himesh.data.entity.UserEntity;
import com.himesh.data.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserRepository repository;
	private final Cloudinary cloudinary;
	
	@Override
	public UserResponceDTO createUser(UserRequestDTO dto, MultipartFile image) throws IOException {
		UserEntity user = new UserEntity();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		
		if(image != null && !image.isEmpty()) {
			Map<?, ?> uploadResultMap = cloudinary.uploader().upload(image.getBytes(), Map.of());
			user.setProfileImageUrl((String) uploadResultMap.get("secure_url"));
		}
		return mapToDTO(repository.save(user));
	}
	
	@Override
	public List<UserResponceDTO> getAllUsers() {
		return repository.findAll().stream()
				.map(this::mapToDTO)
				.collect(Collectors.toList());
	}
	@Override
	public UserResponceDTO getUserById(Long id) {
		return repository.findById(id)
				.map(this::mapToDTO)
				.orElseThrow(()->new RuntimeException("User not found!!!"));
	} 
	@Override
	public UserResponceDTO updateUser(Long id, UserRequestDTO dto, MultipartFile image) throws IOException {
		UserEntity entity = repository.findById(id)
				.orElseThrow(()->new RuntimeException("User not found!!!"));
		
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		
		if(image != null && !image.isEmpty()) {
			Map<?, ?> uploadResultMap = cloudinary.uploader().upload(image.getBytes(), Map.of());
			entity.setProfileImageUrl((String) uploadResultMap.get("secure_url"));
		}
		return mapToDTO(repository.save(entity)); 
	}
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
		
	}
	
	public UserResponceDTO mapToDTO(UserEntity entity) {
		UserResponceDTO dto = new UserResponceDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setProfileImageUrl(entity.getProfileImageUrl());
		return dto;
	}	
}
