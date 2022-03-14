package application.model;

public class Worksheet {

	private boolean hasName;
	
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
	 * toggleHasName
	 * 
	 * This method will simulate whether the checkbox is clicked or not, given any kind of click on the CheckBox from the user.
	 * 
	 */
	public void toggleHasName()
	{
		
		this.hasName = (this.hasName==true) ? false:true;
		
	}
	
}
