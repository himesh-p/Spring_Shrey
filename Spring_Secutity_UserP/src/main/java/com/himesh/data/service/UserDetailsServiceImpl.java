package com.himesh.data.service;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.himesh.data.entity.UserEntity;
import com.himesh.data.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity entity = repository.findByEmail(email)
								.orElseThrow(() -> new UsernameNotFoundException("Username not exist!!!"));
		
		return new org.springframework.security.core.userdetails.User(
				entity.getEmail(),
				entity.getPassword(),
				List.of(new SimpleGrantedAuthority("ROLE_USER"))
				);
	}
}
