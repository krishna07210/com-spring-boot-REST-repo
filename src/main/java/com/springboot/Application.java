package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(Application.class, args);
	}
	
	
	@Profile("dev")
	@Bean
	public String dummyBean() {
		return "something";
	}
}
