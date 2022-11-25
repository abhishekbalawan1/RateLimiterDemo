package com.example.RateLimiterDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RateLimiterDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RateLimiterDemoApplication.class, args);
	}

	@Bean
	public RestTemplate template(){
		return new RestTemplate();
	}
}
