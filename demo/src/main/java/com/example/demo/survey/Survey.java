package com.example.demo.survey;

import java.util.List;

public class Survey {
	
	private String id;
	private String title;
	private String Description;
	private List<Question> questions;
	public Survey() {
	}
	public Survey(String id, String title, String description, List<Question> questions) {
		super();
		this.id = id;
		this.title = title;
		Description = description;
		this.questions = questions;
	}
	public String getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return Description;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	@Override
	public String toString() {
		return "Survey [id=" + id + ", title=" + title + ", Description=" + Description + ", questions=" + questions
				+ "]";
	}
	
	
	
	

}
