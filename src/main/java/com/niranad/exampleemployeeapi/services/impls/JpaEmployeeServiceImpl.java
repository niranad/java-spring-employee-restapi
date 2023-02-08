package com.niranad.exampleemployeeapi.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.niranad.exampleemployeeapi.models.Employee;
import com.niranad.exampleemployeeapi.repositories.JpaEmployeeRepo;
import com.niranad.exampleemployeeapi.services.EmployeeService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
@Qualifier(value = "MySQLEmployeeService")
public class JpaEmployeeServiceImpl implements EmployeeService {
	private final JpaEmployeeRepo jpaEmployeeRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return jpaEmployeeRepo.findAll();
	}

	@Override
	public Employee findById(Integer id) {
		return jpaEmployeeRepo.findById(id).get();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return jpaEmployeeRepo.save(employee);
	}

	@Override
	public void updateEmployee(Employee emp) {
		
	}

	@Override
	public Boolean deleteById(Integer id) {
		jpaEmployeeRepo.deleteById(id);
		return Boolean.TRUE;
	}

}
