package com.example.demo.user;

import java.util.List;

//import org.apache.logging.log4j.Logger;

//import java.util.logging.Logger;

//import java.lang.System.Logger;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import ch.qos.logback.classic.Logger;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {
	private UserDetailsRepository repository;
	public UserDetailsCommandLineRunner(UserDetailsRepository repository) {
		super();
		this.repository=repository;
	}
	
	private Logger logger= LoggerFactory.getLogger(getClass());
	
	@Override
	public void run(String... args) throws Exception{
		repository.save(new UserDetails("Rahul","admin"));
		repository.save(new UserDetails("Akash","admin"));
		repository.save(new UserDetails("Amit","User"));
		repository.save(new UserDetails("Subhadip","New1 joiner"));
		
		List<UserDetails> user1=repository.findByRole("admin");
		
//		eti sob user ke eksathe ene dekhar jonno
		List<UserDetails> users= repository.findAll();
		users.forEach(user-> logger.info( user.toString()));
		user1.forEach(user-> logger.info( user.toString()));
		
		
	}
	

}
