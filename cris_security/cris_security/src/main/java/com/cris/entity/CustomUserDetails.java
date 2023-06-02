package com.cris.entity;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	
	private User user;
	

	public CustomUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		System.out.println("inside getAuthorities()");
		HashSet<SimpleGrantedAuthority> set = new HashSet<>();
		set.add(new SimpleGrantedAuthority(this.user.getRole()));
		
		return set;
	}

	@Override
	public String getPassword() {
		System.out.println("getPassword");
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		System.out.println("getUsername");
		return this.user.getId();
	}

	@Override
	public boolean isAccountNonExpired() {
		System.out.println("isAccountExpired");
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		System.out.println("isAccountBlocked");
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		System.out.println("isCredentialsNonExpired");
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		boolean isEnabled = false;
		System.out.println("isEnabled");
		
		
		return true;
	}

}
