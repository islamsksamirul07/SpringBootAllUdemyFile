package com.example.demo.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloWorldResource {
//	eti amra normal spring boot likhlam
//	@RequestMapping("/helloworld")
//	@ResponseBody
//	public String helloWorld() {
//		return "This my come back on Rest API";
//	}
	
	@RequestMapping("/helloworld")
	public String helloWorld() {
		return "This my come back on Rest API1";
	}
	
//	etite amra HelloWorldBean class tike call kore value transfar kor6i
	@RequestMapping("/hello-world-bean")
	public HelloWorldBean helloworldBean() {
		return new HelloWorldBean("I am tarnsfarring this message");
	}
	
//	etite amra parameter transfar kor6i
	@RequestMapping("/hello-world-bean-param/{name}/message/{message}")
	public HelloWorldBean helloworldBean1(@PathVariable String name, @PathVariable String message) {
		return new HelloWorldBean("I am tarnsfarring this message"+"your name : "+name+" message : "+message);
	}
	
	
}
