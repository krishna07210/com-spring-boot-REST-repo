package com.springboot.jpa.repositories;

import com.springboot.jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; 

@Repository
public interface UserRepository2 extends JpaRepository<User, Long> {
	
}
