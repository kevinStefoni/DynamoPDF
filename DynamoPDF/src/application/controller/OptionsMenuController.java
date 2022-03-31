package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.model.Options.Fonts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OptionsMenuController extends MainMenuController implements Initializable{

	
    @FXML
    private AnchorPane optionsAnchorPane;

    @FXML
    private CheckBox dateCheck;

    @FXML
    private Label optionLabel;

    @FXML
    private CheckBox nameCheck;

    @FXML
    private CheckBox instructionsCheck;

    @FXML
    private CheckBox titleCheck;

    @FXML
    private CheckBox numberedQuestionsCheck;
    
    @FXML
    private TextField numQuestionsTextField;
    
    @FXML
    private TextField numChoicesTextField;
    
    @FXML
    private ComboBox<String> fontChoices;
    
    @FXML
    private ComboBox<String> fontSizes;

    @FXML
    /**
     * 
     * toggleName
     * 
     * This is the controller class that invokes the model class method that toggles the check box within the model.
     * 
     * @param event the name option was selected
     */
    void toggleName(ActionEvent event) {

    	worksheet.toggleHasName();
    	
    }
    
    @FXML
    /**
     * 
     * toggleDate
     * 
     * This is the controller class that invokes the model class method that toggles the check box within the model.
     * 
     * @param event the date option was selected
     */
    void toggleDate(ActionEvent event) {

    	worksheet.toggleHasDate();
    	
    }

    @FXML
    /**
     * 
     * toggleTitle
     * 
     * This is the controller class that invokes the model class method that toggles the check box within the model.
     * 
     * @param event the title option was selected
     */
    void toggleTitle(ActionEvent event) {

    	worksheet.toggleHasTitle();
    	
    }

    @FXML
    /**
     * 
     * toggleInstructions
     * 
     * This is the controller class that invokes the model class method that toggles the check box within the model.
     * 
     * @param event the instructions option was selected
     */
    void toggleInstructions(ActionEvent event) {

    	worksheet.toggleHasInstructions();
    	
    }

    @FXML
    /**
     * 
     * toggleNumberedQuestions
     * 
     * This is the controller class that invokes the model class method that toggles the check box within the model.
     * 
     * @param event the numbered questions option was selected
     */
    void toggleNumberedQuestions(ActionEvent event) {

    	worksheet.toggleHasNumberedQuestions();
    	
    }
    
    @FXML
    /**
     * 
     * setNumQuestions
     * 
     * This method will take the value in the numQuestions text field and store it within the worksheet's QuestionSet object.
     * 
     * @param event either enter is pressed with cursor in text field or "Next" button is pressed
     */
    void setNumQuestions(ActionEvent event) {

    	if(!numQuestionsTextField.getText().equals(""))
    		worksheet.getQuestionSet().setNumQuestions(Integer.parseInt(numQuestionsTextField.getText()));
    	
    }

    @FXML
    /**
     * 
     * setNumChoices
     * 
     * This method will take the value in the numChoices text field and store it within the worksheet's QuestionSet object.
     * 
     * @param event either enter is pressed with cursor in text field or "Next" button is pressed
     */
    void setNumChoices(ActionEvent event) {

    	if(!numChoicesTextField.getText().equals(""))
    		worksheet.getQuestionSet().setNumChoices(Integer.parseInt(numChoicesTextField.getText()));
    	
    }
    
    @FXML
    /**
     * 
     * goToInputs
     * 
     * This method will go to whatever the next scene should be, based on what the user entered.
     * This means it will either go to the title input, instructions input, or question input.
     * It will also trigger other events that may not have triggered like text field events.
     * This method ensures that the maximization, position, whether it is full screen,
     * and size of the window will persist. It also ensures that the minimum height and 
     * width are both 800, to prevent user from shrinking window to such a small size that 
     * there are formatting issues visible.
     * 
     * @param event the "Next" button is pressed
     * @throws IOException
     */
    void goToInputs(ActionEvent event) throws IOException{

    	// Need to ensure that text field data is stored, in case user didn't press enter to trigger event.
    	setNumQuestions(event);
    	setNumChoices(event);
    	
    	String fileName; // the name of the next fxml file
    	
    	// decide what the name of the next file is based on the options the user selected.
    	if(worksheet.getOptions().getHasTitle() == true)
    		fileName = "TitleInput";
    	else if(worksheet.getOptions().getHasInstructions() == true)
    		fileName = "InstructionsInput";
    	else
    		fileName = "QuestionInput";
    	
    	String title = separateCamelCase(fileName); // format the String to make a title for next window

    	// open the file that was determined
    	try {
    		
    		URL url = new File("src/" + fileName + ".fxml").toURI().toURL();
    		Parent loadedFxml = FXMLLoader.load(url);
    		Scene scene = ((Node) event.getSource()).getScene();
    		scene.setRoot(loadedFxml);
    		Stage stg = (Stage)scene.getWindow(); 
    		stg.setTitle(title);
    		stg.setHeight(stg.getHeight());
    		stg.setWidth(stg.getWidth());
    		stg.setX(stg.getX());
    		stg.setY(stg.getY());
    		stg.setMaximized(stg.isMaximized());
    		stg.setFullScreen(stg.isFullScreen());
			stg.setMinHeight(800);
			stg.setMinWidth(800);
    		
    	}
    	catch(IOException ioe)
    	{
    		
    		ioe.printStackTrace();
    		
    	}
    	
    }

    /**
     * 
     * separateCamelCase
     * 
     * This method will add a space between all words in a camelcase word. It will be used to get the titles
     * for the UserInput windows.
     * 
     * @param word a camelcase word
     * @return newWord a String with the camel-cased words separated by a space
     */
    public String separateCamelCase(String word)
    {
    	
    	String newWord = ""; // the new word that will include the extra spaces
    	for(int i = 0; i < word.length(); ++i)
    	{
    		
    		// First letter doesn't need a space behind it, but all subsequent upper case letters need a space behind them
    		if(i != 0 && Character.isUpperCase(word.charAt(i)))
    			newWord += " ";
    		
    		newWord += String.valueOf(word.charAt(i)); // concatenate the letter
    		
    		
    	}
    	return newWord;
    	
    }
    
    
    /**
     * 
     * creates a combobox to allow the user to choose the font
     * choices are times new roman, helvetica, and courier
     * creates a combobox to allow the user to select the font
     * there are 4 different sizes to choose from, and the user can input their own size if necessary
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	if (fontChoices != null) {
    		for (Fonts font : Fonts.values()) {

    			fontChoices.getItems().add(font.toString());
    		}
    	
    		fontChoices.setOnAction((event) -> {
    			String fontChoice = fontChoices.getValue();
    			System.out.println(fontChoice);
    			if(!fontChoice.equals(""))
    				worksheet.getOptions().setFont(Fonts.valueOf(fontChoice));
    		});
    	}
    	if (fontSizes != null) {
    		fontSizes.getItems().add("10");
    		fontSizes.getItems().add("12");
    		fontSizes.getItems().add("14");
    		fontSizes.getItems().add("16");
    		fontSizes.setEditable(true);
    		fontChoices.setOnAction((event) -> {
    			String fontSize = fontSizes.getValue();
    			System.out.println(fontSize);
    			if(!fontSize.equals(""))
    				worksheet.getOptions().setFontSize(Float.valueOf(fontSize));
    		});
    	}
    }
    
    
}