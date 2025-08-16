package com.royal.auth.service;

import org.springframework.stereotype.Service;

import com.royal.auth.dto.UserDTO;
import com.royal.auth.entity.UserEntity;
import com.royal.auth.repository.UserRepository;
import com.royal.auth.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserRepository repository;
	private final JwtUtil jwtUtil;
	
	@Override
	public String authenticate(UserDTO userDTO) {
		UserEntity entity = repository.findByUsername(userDTO.getUsername())
				.orElseThrow(()-> new RuntimeException("User not found"));
		
		if(!entity.getPassword().equals(userDTO.getPassword())) {
			throw new RuntimeException("Invalid Password");
		}
		
		return jwtUtil.generateToken(entity.getUsername());
	}
}