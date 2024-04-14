package com.microservice.wastemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceWastemanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceWastemanagerApplication.class, args);
	}

}
