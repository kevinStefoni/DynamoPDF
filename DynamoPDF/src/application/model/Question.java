package application.model;

import java.util.ArrayList;

public class Question {

	private String question; // the actual question being asked
	private ArrayList<String> choices; // the choices given for the question
	
	/**
	 * 
	 * Question
	 * 
	 * The default constructor for the question class with overly generic information
	 * 
	 */
	public Question()
	{
		
		this.question = "This is a question.";
		
	}
	
	/**
	 * 
	 * Question
	 * 
	 * The primary constructor for the question class that initializes the basic information of the question.
	 * @param question the text of the question being asked
	 * 
	 */
	public Question(String question)
	{
		
		this.question = question;
		
	}
	
	/**
	 * 
	 * getQuestion
	 * 
	 * This is the getter method for question.
	 * 
	 * @return question the text of the question
	 */
	public String getQuestion()
	{
		
		return this.question;
		
	}
	
	/**
	 * 
	 * setQuestion
	 * 
	 * This is the setter method for question.
	 * 
	 * @param question the text of the question
	 */
	public void setQuestion(String question)
	{
		
		this.question = question;
		
	}
	
}
