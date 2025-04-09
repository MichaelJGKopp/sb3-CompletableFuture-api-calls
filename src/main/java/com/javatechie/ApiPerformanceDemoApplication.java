package com.javatechie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ApiPerformanceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPerformanceDemoApplication.class, args);
	}

}
