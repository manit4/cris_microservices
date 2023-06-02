package com.example;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@RequestMapping("/msg")
	public String getMessage() {
		
		System.out.println("inside getMessage()...");
		
		return "Hello JWT";
	}

}
