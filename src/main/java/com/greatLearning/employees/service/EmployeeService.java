package com.greatLearning.employees.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatLearning.employees.entity.Employee;
import com.greatLearning.employees.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired	
	EmployeeRepository employee;
	
	public List<Employee> getAll(){
		return employee.findAll();
	}
	public Optional<Employee> getEmployeeSpecific(int id){
		return employee.findById(id);
	}
	
	public Employee saveEmployee(Employee emp) {
		return employee.save(emp);
	}
	
	public void updateEmployee(int id,Employee empl) {
		if(employee.findById(id).isPresent())
		{
			Employee emp = employee.findById(id).get();
				emp.setEmpFirstName(empl.getEmpFirstName());
				emp.setEmpLastName(empl.getEmpLastName());
				emp.setEmail(empl.getEmail());
			    employee.save(emp);
			    
		}
		
	}
	
	public List<Employee> searchByFirstName(String name){
		Employee emp = new Employee();
		emp.setEmpFirstName(name);
		ExampleMatcher exampleMatcher = ExampleMatcher
				.matching()
				.withMatcher(name, ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("employeeId","lastName","email");
		
		Example<Employee> example = Example.of(emp, exampleMatcher);
		
		return employee.findAll(example);
		
	}
	
	public List<Employee> searchBySorting(Direction d){
		return employee.findAll(Sort.by(d,"empFirstName"));
	}
	public Employee getEmployeeById(int id) {
		return employee.findById(id).get();
		
	}
	public void deleteById(int id) {
		if(employee.findById(id).isPresent())
		{
			employee.deleteById(id);
		}
	}

}
