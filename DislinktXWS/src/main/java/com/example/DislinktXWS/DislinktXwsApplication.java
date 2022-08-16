package com.example.DislinktXWS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DislinktXwsApplication {

	@Autowired
	InsertData data;
	public static void main(String[] args) {
		SpringApplication.run(DislinktXwsApplication.class, args);
	}

}
