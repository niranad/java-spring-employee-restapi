package com.niranad.exampleemployeeapi.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.niranad.exampleemployeeapi.models.Employee;
import com.niranad.exampleemployeeapi.repositories.InMemoryEmployeeRepo;
import com.niranad.exampleemployeeapi.services.EmployeeService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
@Qualifier(value = "InMemoryEmployeeService")
public class InMemoryEmployeeService implements EmployeeService {
	private final InMemoryEmployeeRepo inMemoryEmployeeRepo;
	
	@Override
	public List<Employee> getAllEmployees() {
		return inMemoryEmployeeRepo.getAllEmployees();
	}

	@Override
	public Employee findById(Integer id) {
		return inMemoryEmployeeRepo.findById(id);
	}

	@Override
	public Employee addEmployee(Employee emp) {
		return inMemoryEmployeeRepo.addEmployee(emp);
	}

	@Override
	public void updateEmployee(Employee emp) {
		inMemoryEmployeeRepo.updateEmployee(emp);
	}

	@Override
	public Boolean deleteById(Integer id) {
		inMemoryEmployeeRepo.deleteById(id);
		return Boolean.TRUE;
	}
	 
}
