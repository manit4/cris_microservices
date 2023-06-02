package com.example.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	UserRepository userRepository;
	
	UserService userService;
	
	@BeforeEach
	void setUp() {
		
		this.userService = new UserService(this.userRepository);
	}
	
	@Test
	void getAllUsersTest() {
		
		userService.getAllUsers();
		
		verify(userRepository).findAll();
	}
}
