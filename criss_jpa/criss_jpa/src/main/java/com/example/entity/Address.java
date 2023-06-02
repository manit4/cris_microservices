package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	@Id
	private String addressId;
	private String city;
	private String state;
	
//	@OneToOne
//	@JoinColumn(name = "username")
//	private User user;
	
	@ManyToOne
	private User user;
	
	

}
