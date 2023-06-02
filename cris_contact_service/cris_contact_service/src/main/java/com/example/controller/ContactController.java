package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ContactService;
import com.example.to.Contact;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	@GetMapping("/getContact/{userId}")
	public Contact getContact(@PathVariable String userId) {
		
		System.out.println("userid is "+userId);
		
		Contact contact = contactService.getContactByUserId(userId);
		
		return contact;
	}

}
