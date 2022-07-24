package com.greatLearning.employees.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatLearning.employees.repository.UserRepository;
import com.greatLearning.employees.security.MyUserDetails;

public class UserServiceDetailsImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(userRepo.getUserByUserName(username) == null)
		{
			throw new UsernameNotFoundException("user not found");
		}
			
		// TODO Auto-generated method stub
		return new MyUserDetails(userRepo.getUserByUserName(username));
	}

}
