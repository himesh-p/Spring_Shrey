package com.himesh.data.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	private String email;
	
	@OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL)
	private List<Order> order;
}
