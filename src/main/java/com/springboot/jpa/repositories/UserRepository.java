package com.springboot.jpa.repositories;

import com.springboot.jpa.entities.User;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findByRole(String role);

}
