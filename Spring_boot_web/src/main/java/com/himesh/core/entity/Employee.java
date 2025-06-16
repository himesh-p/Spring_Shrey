package com.himesh.core.entity;

import lombok.Data;

@Data
public class Employee {
	private int id;
	private String name;
	private String email;
	private double salary;
	private String address;
}