package com.vrx.dinehub.foodcatalogueservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FoodCatalogueServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodCatalogueServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced //eureka will redirect to such instance which is not busy
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
