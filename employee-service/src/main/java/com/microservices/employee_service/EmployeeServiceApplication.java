package com.microservices.employee_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class EmployeeServiceApplication {

	@Value("${api.base.url}")
	private String BASE_URL;

	@Bean
	public WebClient getWebClient() {
		return WebClient.builder().baseUrl(BASE_URL).build();
	}

//	@Bean
//	public RestTemplate getRestTemplate(){
//		return new RestTemplate();
//	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
