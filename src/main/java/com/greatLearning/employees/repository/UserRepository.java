package com.greatLearning.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatLearning.employees.entity.Users;

public interface UserRepository extends JpaRepository<Users,Integer> {

	public Users getUserByUserName(String username);
}
