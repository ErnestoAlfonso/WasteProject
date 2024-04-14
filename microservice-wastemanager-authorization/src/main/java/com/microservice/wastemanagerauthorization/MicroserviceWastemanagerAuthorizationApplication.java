package com.microservice.wastemanagerauthorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceWastemanagerAuthorizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceWastemanagerAuthorizationApplication.class, args);
	}

}
