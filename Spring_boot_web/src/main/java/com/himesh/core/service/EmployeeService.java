package com.himesh.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himesh.core.entity.Employee;
import com.himesh.core.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAll(){
		return employeeRepository.findAll();
	}
	
	public Employee getById(int id) {
		return employeeRepository.findById(id);
	}
	
	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void updateEmployee(Employee employee) {
		employeeRepository.update(employee);
	}
	
	public void deleteEmployee(int id) {
		employeeRepository.delete(id);
	}
}
