package com.example.demo.survey;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class SurveyResource {
	private SurveyService surveyService;

	public SurveyResource(SurveyService surveyService) {
		super();
		this.surveyService = surveyService;
	}
	
	@RequestMapping("/surveys")
	public List<Survey> retriveAllSurveyReturn(){
		return surveyService.retriveAllSurvey();
	}
	
//	eti amra url bar e ID diye survey access korbo
	@RequestMapping("/surveys/{surveyId}")
	public Survey retriveSurveyByIdRetuen(@PathVariable String surveyId) {
		Survey survey=surveyService.retriveSurveyById(surveyId);
		if(survey==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		}
		return survey;
	}
	
//	etir dara amra je question guli a6e suguli display korbo
	@RequestMapping("/surveys/{surveyId}/questions")
	public List<Question> retriveAllSurveyQuestion(@PathVariable String surveyId){
		
		List<Question> questions=surveyService.retriveAllSurveyQuestion(surveyId);
		if(questions==null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return questions;
		
	}
	
//	er dara amra Talend API Tester er through er dara amra Question add korbo
//	@RequestMapping(value="/surveys/{surveyId}/questions",method=RequestMethod.POST)
//	public void addNewSurveyQuestion(@PathVariable String surveyId,@RequestBody Question question) {
//		surveyService.addNewSurveyQuestion(surveyId,question);
//	}
	
//	er dara amra Talend API Tester er through er dara amra Question add, random question number generate 
//	and reaponse status, return path for the question number where it is store.
	@RequestMapping(value="/surveys/{surveyId}/questions",method=RequestMethod.POST)
	public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String surveyId,@RequestBody Question question) {
		String questionId=surveyService.addNewSurveyQuestion(surveyId, question);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{questionId}").buildAndExpand(questionId)
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	
//	er dara amra kono ekti question ie Id diye puro question answer tike access korbo. Example- Question1
	@RequestMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retriveSpecificSurveyQuestion(@PathVariable String surveyId, @PathVariable String questionId)
	{
		Question question=surveyService.retriveSpecificSurveyQustion(surveyId,questionId);
		if(question==null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return question;
	}
	
//	Delete a Question by REST API with Talend API Tester
	@RequestMapping(value="surveys/{surveyId}/questions/{questionId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteSurveyQuestion(@PathVariable String surveyId,@PathVariable String questionId)
	{
		surveyService.deleteSurveyQuestion(surveyId,questionId);
		return ResponseEntity.noContent().build();
	}
	
//	Update a Question by REST API with Talend API Tester
	@RequestMapping(value="surveys/{surveyId}/questions/{questionId}", method=RequestMethod.PUT)
	public ResponseEntity<Object> UpdateSurveyQuestion(@PathVariable String surveyId,@PathVariable String questionId,@RequestBody Question question)
	{
		surveyService.updateSurveyQuestion(surveyId, questionId, question);
		return ResponseEntity.noContent().build();
	}
	
	

	

}
