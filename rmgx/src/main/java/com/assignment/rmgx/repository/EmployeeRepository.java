package com.assignment.rmgx.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.assignment.rmgx.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	public List<Employee> findAll();
	public Optional<Employee> findById(Long id);
}
