package com.greatLearning.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatLearning.employees.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles,Integer> {

}
