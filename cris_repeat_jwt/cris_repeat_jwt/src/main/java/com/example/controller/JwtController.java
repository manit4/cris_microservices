package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.JwtUtil;
import com.example.service.CustomUserDetailsService;
import com.example.to.JwtRequest;

@RestController
public class JwtController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	CustomUserDetailsService customUserDetailsService;

	@RequestMapping(value = "/token", method = RequestMethod.POST)
	public String generateToken(@RequestBody JwtRequest jwtRequest) {

		System.out.println("JWTRequest is " + jwtRequest);

		try {

			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (Exception e) {

			System.out.println("inside catch");
		}

		UserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

		String token = this.jwtUtil.generateJwtToken(userDetails);

		return token;

	}

}
