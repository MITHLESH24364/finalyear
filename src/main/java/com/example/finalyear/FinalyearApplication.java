package com.example.finalyear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.finalyear.repo")
public class FinalyearApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalyearApplication.class, args);
	}

}
