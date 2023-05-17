package com.example.demo.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserDetails {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String role;
	
//	eti UserDetailsCommandLineRunner thik thak kaj korbe 
	public UserDetails() {
		
	}
	
	
	public UserDetails(String name, String role) {
		super();
//		this.id = id;
		this.name = name;
		this.role = role;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getRole() {
		return role;
	}
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	
	

}
