package com.company.core.service;

import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.company.core.entity.UserEntity;
import com.company.core.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService implements UserDetailsService{
	
	private final UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity entity = repository.findByUsername(username).orElseThrow(
								() -> new UsernameNotFoundException("Username not found!!!"));
		return new org.springframework.security.core.userdetails.User(
					entity.getUsername(),
					entity.getPassword(),
					Collections.singleton(()-> "ROLE_" + entity.getRole().name())
				);
	}	
}