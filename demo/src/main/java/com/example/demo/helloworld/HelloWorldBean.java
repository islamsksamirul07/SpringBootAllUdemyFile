package com.example.demo.helloworld;

public class HelloWorldBean {
	

	public HelloWorldBean(String message) {
		super();
		// TODO Auto-generated constructor stub
		this.message=message;
	}
	private String message;
	public String getMessage() {
		return message;
	}
	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	
	

}
