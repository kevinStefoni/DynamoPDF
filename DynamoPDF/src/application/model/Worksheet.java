package application.model;

import java.util.ArrayList;

public class Worksheet {

	private boolean hasName;
	private boolean hasDate;
	private boolean hasTitle;
	private boolean hasInstructions;
	private boolean hasNumberedQuestions;
	
	private QuestionSet questionSet;
	
	private String title;
	
	private String fileName;
	
	/**
	 * 
	 * Worksheet
	 * 
	 * The default and primary constructor for the worksheet class. There won't be a constructor where parameters
	 * are passed, because the parameters will all have default values and will be dynamically toggled or changed
	 * by the user. Another design could have had the OptionsMenuController class store everything, then instantiate
	 * a worksheet object at the end, but this design seems to follow MVC design patterns more closely and makes more sense.
	 * 
	 */
	public Worksheet()
	{
		
		this.hasName = false;
		this.hasDate = false;
		this.hasTitle = false;
		this.hasInstructions = false;
		this.hasNumberedQuestions = false;
		
		this.questionSet = new QuestionSet();
		
	}
	
	/**
	 * 
	 * getHasName
	 * 
	 * The getter method for hasName.
	 * 
	 * @return whether the worksheet will have a line for user to enter their name
	 */
	public boolean getHasName()
	{
		
		return this.hasName;
		
	}
	
	/**
	 * 
	 * setHasName
	 * 
	 * The setter method for hasName.
	 * 
	 * @param hasName whether the worksheet will have a line for user to enter their name
	 */
	public void setHasName(boolean hasName)
	{
		
		this.hasName = hasName;
		
	}
	
	/**
	 * 
	 * getHasDate
	 * 
	 * The getter method for hasDate.
	 * 
	 * @return hasDate whether the worksheet will have a line for the date
	 */
	public boolean getHasDate()
	{
		
		return this.hasDate;
		
	}
	
	/**
	 * 
	 * setHasDate
	 * 
	 * The setter method for hasDate.
	 * 
	 * @param hasDate whether the worksheet will have a line for the date
	 */
	public void setHasDate(boolean hasDate)
	{
		
		this.hasDate = hasDate;
		
	}
	
	/**
	 * 
	 * getHasTitle
	 * 
	 * The getter method for hasTitle.
	 * 
	 * @return hasTitle whether the worksheet will have a title
	 */
	public boolean getHasTitle()
	{
		
		return this.hasTitle;
		
	}
	
	/**
	 * 
	 * setHasTitle
	 * 
	 * The setter method for hasTitle.
	 * 
	 * @param hasTitle whether the worksheet will have a title
	 */
	public void setHasTitle(boolean hasTitle)
	{
		
		this.hasTitle = hasTitle;
		
	}
	
	/**
	 * 
	 * getHasInstructions
	 * 
	 * The getter method for hasInstructions.
	 * 
	 * @return has whether the worksheet will have instructions at the top
	 */
	public boolean getHasInstructions()
	{
		
		return this.hasInstructions;
		
	}
	
	/**
	 * 
	 * setHasInstructions
	 * 
	 * The setter method for hasInstructions.
	 * 
	 * @param has whether the worksheet will have instructions at the top
	 */
	public void setHasInstructions(boolean hasInstructions)
	{
		
		this.hasInstructions = hasInstructions;
		
	}
	
	/**
	 * 
	 * getHasNumberedQuestions
	 * 
	 * The getter method for hasNumberedQuestions.
	 * 
	 * @return has whether the worksheet will have numbered questions
	 */
	public boolean getHasNumberedQuestions()
	{
		
		return this.hasNumberedQuestions;
		
	}
	
	/**
	 * 
	 * setHasNumberedQuestions
	 * 
	 * The setter method for hasNumberedQuestions.
	 * 
	 * @param has whether the worksheet will have numbered questions
	 */
	public void setHasNumberedQuestions(boolean hasNumberedQuestions)
	{
		
		this.hasNumberedQuestions = hasNumberedQuestions;
		
	}
	
	public QuestionSet getQuestionSet()
	{
		
		return this.questionSet;
		
	}
	
	/**
	 * 
	 * toggleHasName
	 * 
	 * This method will simulate whether the checkbox is clicked or not, given any kind of click on the CheckBox from the user.
	 * This is for the Name checkbox.
	 * 
	 */
	public void toggleHasName()
	{
		
		this.hasName = (this.hasName == true) ? false:true;
		
	}
	
	/**
	 * 
	 * toggleHasDate
	 * 
	 * This method will simulate whether the checkbox is clicked or not, given any kind of click on the CheckBox from the user.
	 * This is for the Date checkbox.
	 * 
	 */
	public void toggleHasDate()
	{
		
		this.hasDate = (this.hasDate == true) ? false:true;
		
	}
	
	/**
	 * 
	 * toggleHasTitle
	 * 
	 * This method will simulate whether the checkbox is clicked or not, given any kind of click on the CheckBox from the user.
	 * This is for the Title checkbox.
	 * 
	 */
	public void toggleHasTitle()
	{
		
		this.hasTitle = (this.hasTitle == true) ? false:true;
		
	}
	
	/**
	 * 
	 * toggleHasInstructions
	 * 
	 * This method will simulate whether the checkbox is clicked or not, given any kind of click on the CheckBox from the user.
	 * This is for the Instructions checkbox.
	 * 
	 */
	public void toggleHasInstructions()
	{
		
		this.hasInstructions = (this.hasInstructions == true) ? false:true;
		
	}
	
	/**
	 * 
	 * toggleHasNumberedQuestions
	 * 
	 * This method will simulate whether the checkbox is clicked or not, given any kind of click on the CheckBox from the user.
	 * This is for the Numbered Questions checkbox. It will determine if the questions will be numbered.
	 * 
	 */
	public void toggleHasNumberedQuestions()
	{
		
		this.hasNumberedQuestions = (this.hasNumberedQuestions == true) ? false:true;
		
	}
	
}
