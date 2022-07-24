package com.greatLearning.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatLearning.employees.entity.Roles;
import com.greatLearning.employees.service.RolesService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	RolesService roles;
	@RequestMapping("/allRoles")
	public List<Roles> getAllRoles(){
		List<Roles> roleDetails = roles.getRoles();
		return roleDetails;
	}
	@PostMapping("/addRoles")
	public String addRoles(@RequestBody Roles roleDetails) {
		String roleMessage="";
		roles.addRole(roleDetails);
			roleMessage = "Role successfully added";
		return roleMessage;
	}

}
