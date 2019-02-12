package com.quycntt.service;

import java.util.List;

import com.quycntt.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save(Employee employee);
	
	void delete(Employee employee);
}
