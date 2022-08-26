package com.example.JobOffersService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class JobOffersServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobOffersServiceApplication.class, args);
	}

}
