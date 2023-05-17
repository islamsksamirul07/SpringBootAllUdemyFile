package com.example.demo.survey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

//import org.apache.el.stream.Optional;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {
	private static List<Survey> surveys= new ArrayList<>();
	static {
		Question question1=new Question("Question1","most popular cloud platform",Arrays.asList("AWS","Azuer","Google cloud","Oracal"),"AWS");

		Question question2=new Question("Question2","farstest growing cloud platform",Arrays.asList("AWS","Azuer","Google cloud","Oracal"),"Google cloud");

		Question question3=new Question("Question3","Microdoft clouyd platform is : ",Arrays.asList("AWS","Azuer","Google cloud","Azure"),"AWS");
	
		
		List<Question> questions=new ArrayList<>(Arrays.asList(question1,question2,question3));
		Survey survey=new Survey("survey1","my favorite survey","Description of the survey",questions);
		surveys.add(survey);

	}
	public List<Survey> retriveAllSurvey() {
		// TODO Auto-generated method stub
		return surveys;
	}
	
	
//	eti amra ID dara access korbo 
	public Survey retriveSurveyById(String surveyId){
		Predicate <? super Survey> predicate=Survey ->Survey.getId().equals(surveyId);
		Optional <Survey> optionalSurvey=surveys.stream().filter(predicate).findFirst();
		if(optionalSurvey.isEmpty())
			return null;
		return optionalSurvey.get();
		
		
		
	}


	public List<Question> retriveAllSurveyQuestion(String surveyId) {
		// TODO Auto-generated method stub
		
		Survey survey=retriveSurveyById(surveyId);
		if(survey==null)
			return null;
		return survey.getQuestions();
	}


//	er dara amra kono ekti question ie Id diye puro question answer tike access korbo. Example- Question1
	public Question retriveSpecificSurveyQustion(String surveyId, String questionId) {
		// TODO Auto-generated method stub
		
		List<Question> surveyQuestions=retriveAllSurveyQuestion(surveyId);
		if(surveyQuestions==null)
			return null;
		Optional<Question> optionalQuestion=surveyQuestions.stream().filter(p->p.getId().equalsIgnoreCase(questionId)).findFirst();
		if(optionalQuestion.isEmpty())
			return null;
		return optionalQuestion.get();
	}


//	er dara amra Talend API Tester er through er dara amra Question add korbo and amra autometic SurveyId add 
//	kor6i randomly
	public String addNewSurveyQuestion(String surveyId, Question question) {
		// TODO Auto-generated method stub
		 
		
//		eti survey question add korar jonno
		List<Question> questions=retriveAllSurveyQuestion(surveyId);
		question.setId(generateRandomId());
		questions.add(question);
		return question.getId();
		
	}


	private String generateRandomId() {
		SecureRandom secureRandom= new SecureRandom();
		String randomId=new BigInteger(32,secureRandom).toString();
		return randomId;
	}

//	Delete a Question by REST API with Talend API Tester
	public String deleteSurveyQuestion(String surveyId, String questionId) {
		// TODO Auto-generated method stub
		List<Question> surveyQuestion=retriveAllSurveyQuestion(surveyId);
		if(surveyQuestion==null)
			return null;
		Predicate<?super Question> predicate=p->p.getId().equalsIgnoreCase(questionId);
		boolean removed=surveyQuestion.removeIf(predicate);
		if(!removed)
			return null;
		return questionId;
	}

//	Update a Question by REST API with Talend API Tester
	public void updateSurveyQuestion(String surveyId, String questionId, Question question) {
		// TODO Auto-generated method stub
		List<Question> questions=retriveAllSurveyQuestion(surveyId);
		questions.removeIf(p->p.getId().equalsIgnoreCase(questionId));
		questions.add(question);
		
	}
	

	
	
	

}
