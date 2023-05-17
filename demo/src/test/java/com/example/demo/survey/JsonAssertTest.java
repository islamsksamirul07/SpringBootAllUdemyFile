package com.example.demo.survey;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest {

	@Test
	void jsonAssert_learningBasic () throws JSONException{
	String expectedResponse="""
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
}
			""";
	
	String actualResponse="""
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
}
			""";
	

	
	JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	
	}


}
