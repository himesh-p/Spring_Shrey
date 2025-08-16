package com.company.core.config;


import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers(HttpMethod.GET , "/users").permitAll()
				.anyRequest().authenticated()
		)
				.csrf(token -> token.disable())
				.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {          
		return new BCryptPasswordEncoder(12);       // default cost factor is 10 but we can change this like 12.....
	}
	
//	if in application property username and password not take then password encoder not used....
	
//	if we use username and password then in postman we use in authorization basic auth and give user for username and hash of password for password of authorization.....
	
	
}