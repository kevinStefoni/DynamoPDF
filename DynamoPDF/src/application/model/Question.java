package application.model;

public class Question {

	private String question; // the actual question being asked
	
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
	
}
