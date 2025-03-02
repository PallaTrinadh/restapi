package com.hibernate.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootRestApi3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestApi3Application.class, args);
	}

}
