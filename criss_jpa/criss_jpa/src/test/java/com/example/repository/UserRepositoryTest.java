package com.example.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.User;

@SpringBootTest
class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	void findByName() {
		
		System.out.println("iiii");
		
		//User user = new User
		
		List<User> users = userRepository.findByName("Sanjeet");
		
		assertThat(users.size()).isEqualTo(1);
	}

}
