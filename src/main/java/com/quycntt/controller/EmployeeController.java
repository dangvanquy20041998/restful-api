package com.quycntt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quycntt.entity.Employee;
import com.quycntt.serviceimp.EmployeeServiceImp;

@RestController
@RequestMapping(value="/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImp employeeServiceImp;
	
	@GetMapping(value="/employees")
	public List<Employee> findAll() {
		return employeeServiceImp.findAll();
	}
	
	@GetMapping(value="/employee/{id}")
	public Employee findById(@PathVariable(value="id") int id) {
		return employeeServiceImp.findById(id);
	}
	
	@PostMapping(value="/employee")
	public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		return employeeServiceImp.save(employee);
	}
	
	@PutMapping(value="/employee/{id}")
	public ResponseEntity<Employee> update(@PathVariable(value="id") int id, @Valid @RequestBody Employee employee) {
		Employee emp = employeeServiceImp.findById(id);
		
		if(emp == null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setName(employee.getName());
		emp.setPhone(employee.getPhone());
		emp.setAddress(employee.getAddress());
		
		Employee updateEmployee = employeeServiceImp.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
	}
	
	@DeleteMapping(value="/employee/{id}")
	public ResponseEntity<Employee> delete(@PathVariable(value="id") int id) {
		Employee employee = employeeServiceImp.findById(id);
		
		if (employee == null) {
			return ResponseEntity.notFound().build();
		} else {
			employeeServiceImp.delete(employee);
			return ResponseEntity.ok().build();
		}
	}
}
