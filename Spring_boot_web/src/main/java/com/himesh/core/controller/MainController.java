package com.himesh.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@GetMapping("/")
	public String homePage() {
		return "home"; 
	}
	 
	@GetMapping("/employees")
	public String employeePage() {
		return "employee";
	}
	
	@GetMapping("/users")
	public String userPage() {
		return "user";
	}
	
	@PostMapping("/employees")
	public String formdata(
			@RequestParam("name") String name1,
			@RequestParam("dept") String dept,
			@RequestParam("salary") double salary,
			@RequestParam("exp") int exp,
            @RequestParam("join_date") String joinDate,
            @RequestParam("dob") String dob,
            @RequestParam("address") String address,
            @RequestParam("city") String city,
            @RequestParam("state") String state,
            @RequestParam("country") String country,
            @RequestParam("zipcode") String zipcode) { 
		 	String[] part = name1.split(" ");
		 	System.out.println("Employee Form Submitted:");
		 	System.out.println("Firstname :- "+part[0]);
		 	System.out.println("Lastname :- "+part[1]);
	        System.out.println("Department: " + dept);
	        System.out.println("Salary: " + salary);
	        System.out.println("Experience: " + exp);
	        System.out.println("Join Date: " + joinDate);
	        System.out.println("DOB: " + dob);
	        System.out.println("Address: " + address);
	        System.out.println("City: " + city);
	        System.out.println("State: " + state);
	        System.out.println("Country: " + country);
	        System.out.println("Zipcode: " + zipcode);

		 return "employee"; 
	}
	@PostMapping("/users")
    public String UserForm(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password) {

        System.out.println("User Form Submitted:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        return "user";
    }
}
