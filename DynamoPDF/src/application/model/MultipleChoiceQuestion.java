package application.model;

import java.util.ArrayList;

public class MultipleChoiceQuestion{

	private String question; // the actual question
	private int numChoices; // the number of answer choices there are
	private ArrayList<String> multipleChoices; // the answer choices user can select for MCQ
	
	/**
	 * 
	 * MultipleChoiceQuestion
	 * 
	 * This is the default constructor that initializes everything with overly generic information.
	 * 
	 */
	public MultipleChoiceQuestion()
	{
		
		this.question = "This is a question.";
		this.numChoices = 4;		
		this.multipleChoices = new ArrayList<String>();
		
	}
	
	/**
	 * 
	 * MultipleChoiceQuestion
	 * 
	 * This is the primary constructor that initializes all of the information for a multiple choice question.
	 * 
	 * @param question the String with the question being asked
	 * @param numChoices the number of choices given for this multiple choice question
	 * 
	 */
	public MultipleChoiceQuestion(String question, int numChoices)
	{
		
		this.question = question;
		this.numChoices = numChoices;
		this.multipleChoices = new ArrayList<String>();
		
	}
	
	/**
	 * 
	 * addChoice
	 * 
	 * This method simply adds one choice to a multiple choice question.
	 * 
	 * @param newAnswerChoice a String with the answer choice to be added
	 * 
	 */
	public void addChoice(String newAnswerChoice)
	{
		
		this.multipleChoices.add(newAnswerChoice);
		
	}
	
	/**
	 * 
	 * getQuestion
	 * 
	 * This is the getter method for question.
	 * 
	 * @return question the text for the question
	 * 
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
	 * @param question the text for the question
	 * 
	 */
	public void setQuestion(String question)
	{
		
		this.question = question;
		
	}
	
	/**
	 * 
	 * getMultipleChoices
	 * 
	 * This is the getter method for multipleChoices.
	 * 
	 * @return multipleChoices all the answer choices for a question
	 * 
	 */
	public ArrayList<String> getMultipleChoices()
	{
		
		return this.multipleChoices;
		
	}
}
