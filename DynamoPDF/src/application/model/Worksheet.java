package application.model;

public class Worksheet{

	private Options options;
	private QuestionSet questionSet;
	
	private String title;
	private String instructions;
	
	private String fileName;
	
	/**
	 * 
	 * Worksheet
	 * 
	 * The default and primary constructor for Worksheet. As the values will be dynamic and given by user, they will just be initialized
	 * with default values.
	 * 
	 */
	public Worksheet()
	{
			
		this.options = new Options();
		this.questionSet = new QuestionSet();
		
		this.title = "Title";
		this.instructions = "Here are the instructions.";
		this.fileName = "file.pdf";
		
	}

	/**
	 * 
	 * getQuestionSet
	 * 
	 * This is the getter method for questionSet.
	 * 
	 * @return QuestionSet the set of questions
	 */
	public QuestionSet getQuestionSet()
	{
		
		return this.questionSet;
		
	}
	
	/**
	 * 
	 * getOptions
	 * 
	 * This is the getter method for the options object.
	 * 
	 * @return options the options that the user selected
	 */
	public Options getOptions()
	{
		
		return this.options;
		
	}
	
	/**
	 * 
	 * getTitle
	 * 
	 * This is the getter method for title.
	 * 
	 * @return title the title that will appear at the top of the worksheet, not the pdf file name
	 */
	public String getTitle()
	{
		
		return this.title;
		
	}
	
	/**
	 * 
	 * setTitle
	 * 
	 * The setter method for title.
	 * 
	 * @param title the title that will appear at the top of the worksheet, not the pdf file name
	 */
	public void setTitle(String title)
	{
		
		this.title = title;
		
	}
	
	/**
	 * 
	 * getInstructions
	 * 
	 * This is the getter method for instructions.
	 * 
	 * @return instructions the instructions that will appear at the top of the worksheet
	 */
	public String getInstructions()
	{
		
		return this.instructions;
		
	}
	
	/**
	 * 
	 * setInstructions
	 * 
	 * The setter method for instructions.
	 * 
	 * @param instructions the instructions that will appear at the top of the worksheet
	 */
	public void setInstructions(String instructions)
	{
		
		this.instructions = instructions;
		
	}
	
	/**
	 * 
	 * getFileName
	 * 
	 * This is the getter method for fileName.
	 * 
	 * @return fileName the name of the pdf file
	 */
	public String getFileName()
	{
		
		return this.fileName;
		
	}
	
	/**
	 * 
	 * setFileName
	 * 
	 * The setter method for fileName.
	 * 
	 * @param fileName the name of the pdf file
	 */
	public void setFileName(String fileName)
	{
		
		this.fileName = fileName;
		
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
		
		options.setHasName((options.getHasName() == true) ? false:true);
		
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
		
		options.setHasDate((options.getHasDate() == true) ? false:true);
		
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
		
		options.setHasTitle((options.getHasTitle() == true) ? false:true);
		
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
		
		options.setHasInstructions((options.getHasInstructions() == true) ? false:true);
		
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
		
		options.setHasNumberedQuestions((options.getHasNumberedQuestions() == true) ? false:true);
		
	}
	
}
