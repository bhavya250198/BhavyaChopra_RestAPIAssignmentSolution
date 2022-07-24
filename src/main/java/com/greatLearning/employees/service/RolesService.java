package com.greatLearning.employees.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatLearning.employees.entity.Roles;
import com.greatLearning.employees.repository.RoleRepository;

@Service
public class RolesService {
	
	@Autowired
	RoleRepository roles;
	
	public List<Roles> getRoles(){
		
		return roles.findAll();
		
	}
	
	public Roles addRole(Roles role) {
		
		return roles.save(role);
	}
	
	public Roles findRoleById(String roleName) {
			List<Roles> det = roles.findAll();
			System.out.println("det"+det.get(0)+det.get(1));
			String roleDetails = roleName.toUpperCase();
		@SuppressWarnings("unlikely-arg-type")
		int roleIndex =	det.indexOf(roleDetails);
		Roles role =null;
		if(roleIndex != -1) {
			role= det.get(roleIndex);
	}
	
		return role;
}
}
