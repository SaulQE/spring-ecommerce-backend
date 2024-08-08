package com.microservice.image;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceImageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceImageApplication.class, args);
	}

}
