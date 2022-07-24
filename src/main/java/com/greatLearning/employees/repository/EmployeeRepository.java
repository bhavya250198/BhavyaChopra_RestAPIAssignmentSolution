package com.greatLearning.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatLearning.employees.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
		
}
