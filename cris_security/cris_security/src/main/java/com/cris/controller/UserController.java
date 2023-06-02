package com.cris.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cris.entity.User;

@RestController
//@RequestMapping("/student")
public class UserController {
	
	@GetMapping("/msg")
	public String getMessage() {
		
		System.out.println("inside getMessage()...");
		
		return "Hello Security";
	}
	
	@GetMapping("/getUser")
	public User getUser() {
		
		return new User("nas@123", "1234", "Naseer");
		
		
	}
	
	
}
