package com.quycntt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quycntt.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Employee findById(int id);
}
