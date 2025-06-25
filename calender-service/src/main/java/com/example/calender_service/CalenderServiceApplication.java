package com.example.calender_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CalenderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalenderServiceApplication.class, args);
		System.out.println("Welcome to Calender Microservice");
	}

}
