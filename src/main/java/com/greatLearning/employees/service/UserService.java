package com.greatLearning.employees.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.employees.entity.Roles;
import com.greatLearning.employees.entity.Users;
import com.greatLearning.employees.repository.RoleRepository;
import com.greatLearning.employees.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository user;
	@Autowired
	RoleRepository roleDetails;
	@Autowired
	RolesService roleService;
	public List<Users> getAllUsers(){
		return user.findAll();
	}

	@SuppressWarnings("unlikely-arg-type")
	public Users addUser(Users userDet) {
		/*
		 * System.out.println(userDet.getRoles().get(0)); List<Roles> existing =
		 * userDet.getRoles(); List<Roles> roles = roleDetails.findAll();
		 * System.out.println("roles"+roles.size()); for(Roles e:existing) {
		 * System.out.println("roleName"+e.getRoleName());
		 * System.out.println("condition"+roleService.findRoleById(e.getRoleName()) !=
		 * null); if(roleService.findRoleById(e.getRoleName()) != null) { Roles r
		 * =roleService.findRoleById(e.getRoleName());
		 * System.out.println("roleId"+r.getRoleId()); e.setRoleId(r.getRoleId()); } }
		 */
		
	return	user.save(userDet);
	 
		
	}
	
}
