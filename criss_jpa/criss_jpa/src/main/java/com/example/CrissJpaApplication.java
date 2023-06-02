package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.Address;
import com.example.entity.User;
import com.example.repository.UserRepository;

@SpringBootApplication
public class CrissJpaApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrissJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		User user = new User("nas@123", "1234", "Naseer", "nas@yahoo.com");
//
//		userRepository.save(user);

//		Optional<User> optional = userRepository.findById("naa@1234");
//		
//		User user = optional.get();
//		
//		System.out.println(user.getUsername()+", "+user.getEmail());

//		Optional<User> optional = userRepository.findById("naa@1234");
//
//		if(optional.isPresent()) {
//			User user = optional.get();
//
//			System.out.println(user.getUsername() + ", " + user.getEmail());
//		}
//		else {
//			
//			System.out.println("No Value Present...");
//		}

		
//		System.out.println(userRepository.findByName("Naseerr").get().size());
		
		//System.out.println(users.size());
		
//		User user = new User();
//		user.setUsername("na@123");   user.setPassword("123");   user.setName("Sanjeet");
//		user.setEmail("san@gmail.com");
//		
//		Address address = new Address();
//		address.setAddressId("001");   address.setCity("Noida");   address.setState("U.P");
//		
//		user.setAddress(address);
//		address.setUser(user);
//		
//		userRepository.save(user);
		
		User user = new User();
		user.setUsername("na@123");   user.setPassword("123");   user.setName("Sanjeet");
		user.setEmail("san@gmail.com");
		
		Address address1 = new Address();
		address1.setAddressId("001");   address1.setCity("Noida");   address1.setState("U.P");
		address1.setUser(user);
		
		Address address2 = new Address();
		address2.setAddressId("002");   address2.setCity("Gurgaon");   address2.setState("Gurgaon");
		address2.setUser(user);
		
		List<Address> addressess = new ArrayList<Address>();
		addressess.add(address1);
		addressess.add(address2);
		
		user.setAddresses(addressess);
		
		userRepository.save(user);
		
		User user1 = userRepository.getUser("Sanjeet");
		
		System.out.println(user1.getEmail());
		
		
		
		
	}

}
