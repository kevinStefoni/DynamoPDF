package application.controller;

import application.model.Worksheet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class OptionsMenuController {

	Worksheet worksheet = new Worksheet();
	
    @FXML
    private AnchorPane optionsAnchorPane;

    @FXML
    private CheckBox dateCheck;

    @FXML
    private Label optionLabel;

    @FXML
    private Pane bottomOptionPane;

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
    /**
     * 
     * toggleName
     * 
     * This is the controller class that invokes the model class method that toggles the check box within the model.
     * 
     * @param event
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
     * @param event
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
     * @param event
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
     * @param event
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
     * @param event
     */
    void toggleNumberedQuestions(ActionEvent event) {

    	worksheet.toggleHasNumberedQuestions();
    	
    }
    
    @FXML
    void setNumQuestions(ActionEvent event) {

    	worksheet.getQuestionSet().setNumQuestions(Integer.parseInt(numQuestionsTextField.getText()));
    	
    }

    @FXML
    void setNumChoices(ActionEvent event) {

    	//worksheet.getQuestionSet().setNumChoices(Integer.parseInt(numChoicesTextField.getText()));
    	
    }
    
}