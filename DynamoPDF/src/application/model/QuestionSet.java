package application.model;

import java.util.ArrayList;

public class QuestionSet {

	int numQuestions; // the number of questions
	private ArrayList<Question>setOfQuestions; // the set of all types of questions
	
	/**
	 * 
	 * QuestionSet
	 * 
	 * The default constructor for the QuestionSet class with overly generic information
	 * 
	 */
	public QuestionSet()
	{
		
		this.numQuestions = 1;
		this.setOfQuestions = new ArrayList<Question>();
		
	}
	
	/**
	 * 
	 * QuestionSet
	 * 
	 * The primary constructor that initializes all of the data for the set of questions.
	 * 
	 * @param numQuestions the number of questions in the set
	 * 
	 */
	public QuestionSet(int numQuestions)
	{
		
		this.numQuestions = numQuestions;
		this.setOfQuestions = new ArrayList<Question>();
		this.setOfQuestions.add(new MultipleChoiceQuestion());
		
	}
}
