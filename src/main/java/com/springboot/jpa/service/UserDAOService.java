package com.springboot.jpa.service;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext; 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.jpa.entities.User;

@Repository
@Transactional
public class UserDAOService {
		
	@PersistenceContext
	private EntityManager entityManager;
	
	// All the things which are there in the Persistence Context are tracked by the Entity Manager
	
	public long insert(User user){
		entityManager.persist(user);
		return user.getId();
	}
}
