package application.model;

import java.util.ArrayList;

public class QuestionSet {

	private int numQuestions;
	private int numChoices;
	private ArrayList<MultipleChoiceQuestion>setOfQuestions; 
	
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
		this.numChoices = 4;
		this.setOfQuestions = new ArrayList<MultipleChoiceQuestion>();
		
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
	public QuestionSet(int numQuestions, int numChoices)
	{
		
		this.numQuestions = numQuestions;
		this.numChoices = numChoices;
		this.setOfQuestions = new ArrayList<MultipleChoiceQuestion>();
		
		
	}
	
	/**
	 * 
	 * getNumQuestions
	 * 
	 * This is the getter method for numQuestions.
	 * 
	 * @return numQuestions the number of questions in the worksheet
	 */
	public int getNumQuestions()
	{
		
		return this.numQuestions;
		
	}
	
	/**
	 * 
	 * setNumQuestions
	 * 
	 * This is the setter method for numQuestions.
	 * 
	 * @param numQuestions the new number of questions in the worksheet
	 */
	public void setNumQuestions(int numQuestions)
	{
		
		this.numQuestions = numQuestions;
		
	}
	
	/**
	 * 
	 * getNumChoices
	 * 
	 * This is the getter method for numChoices.
	 * 
	 * @return numChoices the number of choices per question
	 */
	public int getNumChoices()
	{
		
		return this.numChoices;
		
	}
	
	/**
	 * 
	 * setNumChoices
	 * 
	 * This is the setter method for numChoices.
	 * 
	 * @param numQuestions the new number of choices per question
	 */
	public void setNumChoices(int numChoices)
	{
		
		this.numChoices = numChoices;
		
	}
	
	/**
	 * 
	 * getSetOfQuestions
	 * 
	 * This is the getter method for setOfQuestions.
	 * 
	 * @return setOfQuestions an ArrayList with all the questions in it
	 * 
	 */
	public ArrayList<MultipleChoiceQuestion> getSetOfQuestions()
	{
		
		return this.setOfQuestions;
		
	}
	
	/**
	 * 
	 * addQuestion
	 * 
	 * This is a method to add a question to the setOfQuestions.
	 * 
	 * @param mcquestion the question to be added to the setOfQuestions
	 * 
	 */
	public void addQuestion(MultipleChoiceQuestion mcquestion)
	{
		
		this.setOfQuestions.add(mcquestion);
		
	}

}
