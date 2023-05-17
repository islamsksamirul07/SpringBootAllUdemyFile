package com.example.demo.survey;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
//@SpringBootTest
public class SurveyResourceIT {
//	http://localhost:8080/surveys/survey1/questions/question1
	
//	String str="""
//			{
//"id": "Question1",
//"description": "most popular cloud platform",
//"options": [
//"AWS",
//"Azuer",
//"Google cloud",
//"Oracal"
//],
//"correctAnswer": "AWS"
//}
//			""";
	
	private static String SPECIFIC_QUESTION_URL="/surveys/survey1/questions/question1";
	private static String GENERIC_QUESTION_URL="/surveys/survey1/questions";
	@Autowired
	private TestRestTemplate template;
	
	@Test
	void retriveSpecificSurveyQuestion_basicScenario() {
//		System.out.println("this is testing..1.................."+WebEnvironment.RANDOM_PORT);
		ResponseEntity<String> responseEntity=template.getForEntity(SPECIFIC_QUESTION_URL,String.class);

		
		
		System.out.println("this is testing....................");
		System.out.println(responseEntity.getBody());
		System.out.println(responseEntity.getHeaders());
//		
//		eti 108 er cotaint
		String expectedResponce="""
				{"id":"Question1","description":"most popular cloud platform","options":["AWS","Azuer","Google cloud","Oracal"],"correctAnswer":"AWS"}
							""";
		
//		assertEquals(expectedResponce.trim(), responseEntity.getBody());
		
//		ekhane amra Assert er ki6u function check korbo
		
		//eti response status check korar jonno
		System.out.println("this is assertTrue....................");
//		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		
//		er mane at a time ekti run hoch6e assert
		JSONAssert.assertEquals(expectedResponce.trim(), responseEntity.getBody(),true);
	}
	@Test
	void retriveAllSurveyQuestion_basicSinario() {
		ResponseEntity<String> responseEntity=template.getForEntity(GENERIC_QUESTION_URL,String.class);
		String expectedResponce="""
				[
{
"id": "Question1",
"description": "most popular cloud platform",
"options": [
"AWS",
"Azuer",
"Google cloud",
"Oracal"
],
"correctAnswer": "AWS"
},
{
"id": "Question2",
"description": "farstest growing cloud platform",
"options": [
"AWS",
"Azuer",
"Google cloud",
"Oracal"
],
"correctAnswer": "Google cloud"
},
{
"id": "Question3",
"description": "Microdoft clouyd platform is : ",
"options": [
"AWS",
"Azuer",
"Google cloud",
"Azure"
],
"correctAnswer": "AWS"
}
]
				""";
		String expectedResponce2="""
				[
				{"id":"Question1"
				},
				{"id":"Question2"
				},
				{"id":"Question3"
				}
				]
				""";
		
		System.out.println("This is Testing 2.................");
		System.out.println(expectedResponce.trim());
		System.out.println(responseEntity.getBody());
//		assertEquals(expectedResponce.trim(), responseEntity.getBody());
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
//		JSONAssert.assertEquals(expectedResponce,responseEntity.getBody(),true);
		JSONAssert.assertEquals(expectedResponce2, responseEntity.getBody(), false);
				
	}
	
//	private static String GENERIC_QUESTION_URL_POST="/surveys/survey/questions";
	@Test
	public void addNewSurveyQuestion_basicSinario() {
		String requestBody="""
				{
				"description": "Your most likely programming language",
				"options": [
				"JAVA",
				"Python",
				"JavaScript",
				"css"
				],
				"correctAnswer": "JAVA"
				}
				""";
		HttpHeaders httpHeaders= new HttpHeaders();
		httpHeaders.add("Content-Type","application/json");
		HttpEntity <String> httpEntity=new HttpEntity<String>(requestBody,httpHeaders);
		ResponseEntity <String> responseEntity=template.exchange(GENERIC_QUESTION_URL, HttpMethod.POST, httpEntity, String.class);
		System.out.println(responseEntity.getStatusCode().is2xxSuccessful()+"this is adding");
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertTrue(responseEntity.getHeaders().get("Location").get(0).contains("surveys/survey1/questions/"));
		System.out.println(responseEntity.getHeaders().get("Location").get(0).contains("/surveys/survey1/questions"));
		
//		ekhan theke amader 112 i.e sob test jeno aksathe run hoi seti start hobe
		String locationHeader = responseEntity.getHeaders().get("Location").get(0);
		assertTrue(locationHeader.contains("/surveys/survey1/questions"));
		template.delete(locationHeader);
	}
	

}

