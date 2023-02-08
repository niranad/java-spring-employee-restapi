package com.niranad.exampleemployeeapi.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.niranad.exampleemployeeapi.models.Employee;
import com.niranad.exampleemployeeapi.services.EmployeeService;

@RestController
// @RequiredArgsConstructor
@RequestMapping(path = "/api/employees")
public class EmployeeResource {
	private final EmployeeService employeeService;
	
	public EmployeeResource(@Qualifier("MySQLEmployeeService") EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(employeeService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<List<Employee>> addEmployee(@RequestBody Employee employee) {
		// employee.setId(employeeService.getAllEmployees().size() + 1); //for in-memory implementation
		return ResponseEntity.created(getLocation(employee.getId())).body(employeeService.getAllEmployees());
	}
	
	@DeleteMapping
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(employeeService.deleteById(id));
	}
	
	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Employee employee) {
		employee.setId(employeeService.getAllEmployees().size() + 1);
		return ResponseEntity.ok(employeeService.updateEmployee(employee));
	}
	
	protected static URI getLocation(Integer id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
	}
	
}
