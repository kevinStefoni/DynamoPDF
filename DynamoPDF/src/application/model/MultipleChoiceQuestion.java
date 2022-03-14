package application.model;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question{

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
		
		super();
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
		
		super(question);
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
}