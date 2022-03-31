package application.model;

public class Options {

	public enum Fonts{
		
		TIMES_NEW_ROMAN,
		HELVETICA,
		COURIER
		
	};
	
	
	private boolean hasName;
	private boolean hasDate;
	private boolean hasTitle;
	private boolean hasInstructions;
	private boolean hasNumberedQuestions;
	
	private Fonts font;
	private float fontSize;
	
	/**
	 * 
	 * Options
	 * 
	 * The default and primary constructor for the worksheet class. There won't be a constructor where parameters
	 * are passed, because the parameters will all have default values and will be dynamically toggled or changed
	 * by the user. 
	 * 
	 */
	public Options()
	{
		
		this.hasName = false;
		this.hasDate = false;
		this.hasTitle = false;
		this.hasInstructions = false;
		this.hasNumberedQuestions = false;
		this.font = Fonts.TIMES_NEW_ROMAN;
		this.fontSize = 12;
		
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
	
	/**
	 * 
	 * getFont
	 * 
	 * The getter method for font.
	 * 
	 * @return font an enum value for the font that the document should have it
	 */
	public Fonts getFont()
	{
		
		return this.font;
		
	}
	
	/**
	 * 
	 * setFont
	 * 
	 * The setter method for font.
	 * 
	 * @param font an enum value for the font that the document should have it
	 */
	public void setFont(Fonts font)
	{
		
		this.font = font;
		
	}
	
	/**
	 * 
	 * getFontSize
	 * 
	 * The getter method for fontSize.
	 * 
	 * @return fontSize the size of the font
	 */
	public float getFontSize()
	{
		
		return this.fontSize;
		
	}
	
	/**
	 * 
	 * setFontSize
	 * 
	 * The setter method for fontSize.
	 * 
	 * @param fontSize the size of the font
	 */
	public void setFontSize(float fontSize)
	{
		
		this.fontSize = fontSize;
		
	}
	
	
	
}
