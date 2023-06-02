package com.cris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication

@CrossOrigin
public class CrisSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrisSecurityApplication.class, args);
	}

}
