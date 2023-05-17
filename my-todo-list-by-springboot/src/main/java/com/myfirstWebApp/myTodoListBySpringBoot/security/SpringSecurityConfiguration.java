package com.myfirstWebApp.myTodoListBySpringBoot.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
//	eti dara amra less security pabo nicher dara double
//	@Bean
//	public InMemoryUserDetailsManager createUserDetailsManager() {
//		UserDetails userDetails=User.withDefaultPasswordEncoder()
//				.username("Samirul")
//				.password("dummy")
//				.roles("USER","ADMIN")
//				.build();
//		return new InMemoryUserDetailsManager(userDetails);
//	}
	
//	eti ekti user tkle use korbo
//	@Bean
//	public InMemoryUserDetailsManager createUserDetailsManager() {
//		Function<String, String> passwordEncoder= input-> passwordEncoder().encode(input);
//		UserDetails userDetails=User.builder()
//				.passwordEncoder(passwordEncoder)
//				.username("Samirul")
//				.password("dummy")
//				.roles("USER","ADMIN")
//				.build();
//		return new InMemoryUserDetailsManager(userDetails);
//	}
	
//	eti ekadik user thakle use korbo
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		
		
		UserDetails userDetails1 = createNewUser("Samirul","dummy");
		UserDetails userDetails2 = createNewUser("testingData","dummy");
		UserDetails userDetails3 = createNewUser("test","dummy");
		return new InMemoryUserDetailsManager(userDetails1,userDetails2,userDetails3);
	}


	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder= input-> passwordEncoder().encode(input);
		UserDetails userDetails=User.builder()
				.passwordEncoder(passwordEncoder)
				.username(username)
				.password(password)
				.roles("USER","ADMIN")
				.build();
		return userDetails;
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	eti H2 database er connection er jonno kortei hobe er dara CSRF ke disable and FrameAllow korte hobe
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(
				auth->auth.anyRequest().authenticated()
				);
		http.formLogin();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		return http.build();
		
	}
	
	
	
	

}
