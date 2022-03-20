package application.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class UserInputController extends OptionsMenuController{


		
		/*
		 * To access a data member from Options class from worksheet object, do something like this.
		 * 		 * 
		 * worksheet.getOptions().getHasDate()
		 */
		

    @FXML
    private TextField question1a;

    @FXML
    private TextField question2a;
    
    @FXML
    private TextField question3a;
    
    @FXML
    private TextField question4a;
    
    @FXML
    private TextField question5a;

    @FXML
    private AnchorPane background;

    @FXML
    private TextArea questionBox;

    @FXML
    private Button questionInputNextButton;
    
    public void initialize()
    {
    	
    	//System.out.println(worksheet.getQuestionSet().getNumQuestions() + " " + worksheet.getQuestionSet().getNumChoices());
    	
    }
    
	
}
