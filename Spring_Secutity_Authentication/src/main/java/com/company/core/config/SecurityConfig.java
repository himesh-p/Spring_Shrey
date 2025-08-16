package com.company.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
	
	private final JwtFilter filter;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		return http.csrf(csrt -> csrt.disable())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/auth/**").permitAll()
						.requestMatchers("/products/**").permitAll()
						.anyRequest().authenticated()
				)
				.sessionManagement(sesson -> sesson.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
