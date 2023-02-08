package com.niranad.exampleemployeeapi.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.niranad.exampleemployeeapi.models.Employee;
import com.niranad.exampleemployeeapi.utils.Gender;


@Repository
public class InMemoryEmployeeRepo {
	private static final List<Employee> DATABASE = new ArrayList<>();

	static {
		DATABASE.add(new Employee(1, "John", "Smith", LocalDate.of(1992, 9, 24), "john_smith@gmail.me", 30, "American",
				Gender.MALE));
		DATABASE.add(new Employee(2, "James", "Pogan", LocalDate.of(1987, 4, 13), "j.pogan@yahoo.co.me", 36, "Spanish",
				Gender.MALE));
		DATABASE.add(new Employee(3, "Jane", "Anne", LocalDate.of(1997, 9, 2), "jane.anne@gmail.me", 26, "British",
				Gender.FEMALE));
	}

	public Employee addEmployee(Employee employee) {
		DATABASE.add(employee);
		return employee;
	}

	public List<Employee> getAllEmployees() {
		return List.copyOf(DATABASE);
	}

	public Employee findById(Integer id) {
		return DATABASE
				.stream()
				.filter(emp -> emp.getId().equals(id))
				.findFirst()
				.orElseThrow();
	}

	public void updateEmployee(Employee employee) {
		DATABASE.stream().map(emp -> {
			if (employee.getId().equals(emp.getId())) {
				return employee;
			}
			return emp;
		});
	}

	public Boolean deleteById(Integer id) {
		Employee employee = DATABASE
				.stream()
				.filter(emp -> emp.getId().equals(id))
				.findFirst()
				.orElseThrow();
		DATABASE.remove(employee);
		return Boolean.TRUE;
	}
}
