package com.example.Taller2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TallerPracticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerPracticoApplication.class, args);
	}

	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}