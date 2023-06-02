package com.cris.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cris.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@CrossOrigin
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	CustomUserDetailsService customUserDetailsService;
	
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http
//			.authorizeHttpRequests()
//				.antMatchers("/student/**").hasRole("Student")
//					.anyRequest()
//						.authenticated()
//							.and()
//								.httpBasic();
//
//	}
	
	protected void configure(HttpSecurity http) throws Exception {

		http
			.authorizeHttpRequests()
			.antMatchers("/signin", "/registrationPage", "/register").permitAll()
			.antMatchers("/msg").hasRole("Admin")
				.anyRequest()
						.authenticated()
							.and()
								.formLogin()
									.loginPage("/signin")
										.loginProcessingUrl("/dologin")
											.defaultSuccessUrl("/welcomePage", true);

	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("inside configurer...1");

		

//		auth.inMemoryAuthentication().withUser("Vansh").password("123").roles("EMPLOYEE");
//		auth.inMemoryAuthentication().withUser("Meeraj").password("234").roles("ADMIN");
		
//		String encryptedPassword1 = passwordEncoder().encode("12");
//		String encryptedPassword2 = passwordEncoder().encode("23");
//		
//		System.out.println(encryptedPassword1);
//		System.out.println(encryptedPassword2);
//		
//		auth.inMemoryAuthentication().withUser("Vansh").password(encryptedPassword1).roles("Admin");
//		auth.inMemoryAuthentication().withUser("Shubh").password(encryptedPassword2).roles("Student");
		
		
		auth.userDetailsService(customUserDetailsService).passwordEncoder(this.passwordEncoder());
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}

}
