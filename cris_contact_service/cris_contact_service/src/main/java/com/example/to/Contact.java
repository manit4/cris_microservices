package com.example.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
	
	private String contactId;
	private int houseNumber;
	private String city;
	private String state;
	private String username;

}
