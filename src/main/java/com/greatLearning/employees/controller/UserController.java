package com.greatLearning.employees.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatLearning.employees.entity.Roles;
import com.greatLearning.employees.entity.Users;
import com.greatLearning.employees.service.RolesService;
import com.greatLearning.employees.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService service;
	@Autowired 
	RolesService roleservice;
	@RequestMapping("/getUserList")
	public List<Users> getUsers(){
		return service.getAllUsers();
	}
	
	@PostMapping("/addUser")
	public String saveUser(@RequestBody Users user) {
		
		service.addUser(user);
		return "user details saved";
	}
	

}
