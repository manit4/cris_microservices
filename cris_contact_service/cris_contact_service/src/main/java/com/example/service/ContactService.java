package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.to.Contact;

@Service
public class ContactService {
	
	List<Contact> contacts = new ArrayList<Contact>();
	
	public ContactService() {
		
		System.out.println("inside ContactService constructor...");
		
		Contact contact1 = new Contact("c_001", 56, "Chandigarh", "Punjab and Haryana", "sha@123");
		Contact contact2 = new Contact("c_002", 76, "Bangalore", "Karnataka", "sai@123");
		Contact contact3 = new Contact("c_003", 34, "Noida", "Uttar Pardesh", "suh@123");
		
		contacts.add(contact1);    contacts.add(contact2);    contacts.add(contact3);
	}
	
	public Contact getContactByUserId(String userId) {
		
		for(Contact contact : contacts) {
			
			if(userId.equals(contact.getUsername())) {
				
				return contact;
			}
			
		}
		return null;
	}

}
