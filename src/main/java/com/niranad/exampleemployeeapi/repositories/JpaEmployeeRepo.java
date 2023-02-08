package com.niranad.exampleemployeeapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niranad.exampleemployeeapi.models.Employee;

@Repository
public interface JpaEmployeeRepo extends JpaRepository<Employee, Integer>  {}
