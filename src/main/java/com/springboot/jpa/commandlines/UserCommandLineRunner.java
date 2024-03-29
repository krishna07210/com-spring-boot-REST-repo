package com.springboot.jpa.commandlines;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.jpa.entities.User;
import com.springboot.jpa.repositories.UserRepository;

/**
 * 
 * @author krish
 * Command line runners will be invoked as soon as Applicaion is started.
 */

@Component
public class UserCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);

	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) {
		// save a couple of customers
		repository.save(new User("Ranga", "Admin"));
		repository.save(new User("Ravi", "User"));
		repository.save(new User("Satish", "Admin"));
		repository.save(new User("Raghu", "User"));

		log.info("-------------------------------");
		log.info("Finding all users");
		log.info("-------------------------------");
		for (User user : repository.findAll()) {
			log.info(user.toString());
		}
		
		log.info("------- Admin Users ------");
		for (User user : repository.findByRole("Admin")) {
			log.info(user.toString());
		}
		
	}

}
	