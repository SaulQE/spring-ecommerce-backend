package com.microservice.category;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceCategoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCategoryApplication.class, args);
	}

}
