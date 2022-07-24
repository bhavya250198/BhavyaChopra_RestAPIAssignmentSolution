package com.greatLearning.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatLearning.employees.entity.Employee;
import com.greatLearning.employees.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@RequestMapping("/getAllEmployee")
	public List<Employee> getAllEmployees(){
		return employeeService.getAll();
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/{id}")
	public List<Employee> getEmployeeById(@PathVariable int id){
		List<Employee> emp = null;
		if(employeeService.getEmployeeSpecific(id).isPresent()) {
			emp =(List<Employee>) employeeService.getEmployeeSpecific(id).get();
			
		}
		return emp;
		
		
	}
	
	@RequestMapping("/search")
	public List<Employee> getEmployeeBySearch(@RequestParam("empFirstName")String name){
		return employeeService.searchByFirstName(name);
	}
	
	@RequestMapping("/sortByFirstName")
	public List<Employee> getEmployeeBySort(@RequestParam("direction") Direction d){
		return employeeService.searchBySorting(d);
	}

}
