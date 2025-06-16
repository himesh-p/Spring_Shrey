package com.himesh.core.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

import com.himesh.core.entity.Employee;

@Repository
public class EmployeeRepository {
	private final Map<Integer , Employee> employeeDB = new HashMap<>();
	private int currentId = 1;
	
	public List<Employee> findAll(){
		return new ArrayList<>(employeeDB.values());
	}
	
	public Employee findById(int id) {
		return employeeDB.get(id);
	}
	
	public void save(Employee employee) {
		if(employee.getId() == 0) { 
			employee.setId(currentId);
		}
		employeeDB.put(currentId++, employee);
	}
	
	public void update(Employee employee) {
		if(employeeDB.containsKey(employee.getId())) {
			employeeDB.put(employee.getId(), employee);
		}
	}
	
	public void delete(int id) {
		employeeDB.remove(id);
	}
}
