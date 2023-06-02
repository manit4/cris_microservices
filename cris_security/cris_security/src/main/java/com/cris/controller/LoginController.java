package com.cris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cris.entity.User;
import com.cris.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		
		System.out.println("inside BCrypt");
		
		return new BCryptPasswordEncoder();
	}

	@GetMapping("/signin")
	public String home() {
		
		System.out.println("inside home()");
		
		return "login";
	}
	
	@GetMapping("/registrationPage")
	public String registrationPage() {
		
		System.out.println("registration Page...");
		
		return "registration";
	}
	
	@GetMapping("/register")
	public String register(User user) {
		
		System.out.println("inside register()...");
		
		String encrypedPassword =  encoder().encode(user.getPassword());
		
		user.setPassword(encrypedPassword);
		
		userService.addUser(user);
		
		return "login";
	}
	
	@GetMapping("/welcomePage")
	public String welcomePage() {
		
		return "welcome";
	}
	
}
