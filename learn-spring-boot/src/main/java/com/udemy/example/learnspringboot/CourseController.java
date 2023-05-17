package com.udemy.example.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8080/courses
//	eta nicher type er data return korbe
//			{
//				"id":1,
//				"name": "SpringBoot",
//				"author":"Samirul"
//			}

//Course: id, name, author
@RestController

public class CourseController {
	@RequestMapping("/courses")
	public List<Course> retriveAllCourses(){
		return Arrays.asList(
				new Course(1, "SpringBoot","Samirul"),
				new Course(2, "React","New Samirul nmmgngf"),
				new Course(3, "Redis", "Learning Samirul")
				
				);
				
	}

}
