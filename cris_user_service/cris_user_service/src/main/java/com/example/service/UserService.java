package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.to.User;

@Service
public class UserService {
	
	List<User> users = new ArrayList<User>();

	public UserService() {
		
		System.out.println("inside UserService constructor...");
		User user1 = new User("suh@123", "1234", "Suhail Ali", null);
		User user2 = new User("sha@123", "2345", "Shalini Singh", null);
		User user3 = new User("sai@123", "3456", "Sai Madhuri", null);
		
		users.add(user1);    users.add(user2);   users.add(user3);
	}
	
	public User getUser(String userId) {
		
		for(User user : users) {
			
			if(userId.equals(user.getUsername())) {
				return user;
			}
		}
		return null;
	}
}
