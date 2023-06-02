package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	JwtAuthenticationFilter authenticationFilter;
	
	protected void configure(HttpSecurity http) throws Exception {

		http
		.csrf()
			.disable()
				.cors()
					.disable()
						.authorizeHttpRequests()
							.antMatchers("/token").permitAll()
								.anyRequest()
									.authenticated()
										.and()
											.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
								

	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return authenticationManager();
	}

}
