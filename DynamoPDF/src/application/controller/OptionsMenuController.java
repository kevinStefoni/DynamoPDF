package application.controller;

import application.model.Worksheet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
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
    private Label numberOfChoices;

    @FXML
    private Label numberOfQuestions;

    @FXML
    private CheckBox titleCheck;

    @FXML
    private CheckBox numberedQuestionsCheck;

    @FXML
    void toggleName(ActionEvent event) {

    	worksheet.toggleHasName();
    	
    }
    
}