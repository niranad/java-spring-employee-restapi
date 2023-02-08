package com.niranad.exampleemployeeapi.services;

import java.util.List;

import com.niranad.exampleemployeeapi.models.Employee;


public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	
	Employee findById(Integer id);
	
	Employee addEmployee(Employee emp);
		
	Employee updateEmployee(Employee emp);
	
	Employee deleteById(Integer id);
}
