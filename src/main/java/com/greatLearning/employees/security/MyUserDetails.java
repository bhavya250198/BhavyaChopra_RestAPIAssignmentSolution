package com.greatLearning.employees.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.greatLearning.employees.entity.Roles;
import com.greatLearning.employees.entity.Users;

public class MyUserDetails implements UserDetails {
	
	private Users user;
	public MyUserDetails(Users user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Roles> role = user.getRoles();
		List<SimpleGrantedAuthority> simple = new ArrayList<SimpleGrantedAuthority>();
		for(Roles r :role) {
			simple.add(new SimpleGrantedAuthority(r.getRoleName()));
		}
		
		// TODO Auto-generated method stub
		return simple;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
