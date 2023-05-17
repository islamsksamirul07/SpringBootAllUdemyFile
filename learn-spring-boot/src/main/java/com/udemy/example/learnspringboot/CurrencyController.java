package com.udemy.example.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//http://localhost:8080/courses
//	eta nicher type er data return korbe
//			{
//				"id":1,
//				"name": "SpringBoot",
//				"author":"Samirul"
//			}

//Course: id, name, author
@RestController



public class CurrencyController {
	@Autowired
	private CurrencyServiceConfiguration config;

	@RequestMapping("/currency-service")
	public CurrencyServiceConfiguration SentService(){
		return config;
				
	}

}
