package com.graphql.springboot.project;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ADemoProjectApplication {

	@Value("spring.application.name")
	private String name;
	
	public static void main(String[] args) {
		new ADemoProjectApplication().display();
		SpringApplication.run(ADemoProjectApplication.class, args);
	}
	
	public void display() {
		System.out.println(name);
	}

}
