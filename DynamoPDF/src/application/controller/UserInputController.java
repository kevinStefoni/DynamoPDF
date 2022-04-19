package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import application.model.MultipleChoiceQuestion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserInputController extends OptionsMenuController {

	// titleInput.fxml
	@FXML
	private TextField titleInput;
	
    
	// instructionsInput.fxml	
	@FXML
	private TextArea instructionsInput;
	
	
    // questionInput.fxml
    @FXML
    private TextArea questionBox;
    
    @FXML
    private TextField questionA;

    @FXML
    private TextField questionB;
    
    @FXML
    private TextField questionC;
    
    @FXML
    private TextField questionD;
    
    @FXML
    private TextField questionE;

    @FXML
    private Label warningMessage;

    @FXML
    private Label qLabelMain;
    
    /**
     * 
     * saveTitle
     * 
     * This is the method that stores the title from the text field into the worksheet object.
     * 
     */
    public void saveTitle() {
    	
    	worksheet.setTitle(titleInput.getText());
   
    }
    
    /**
     * 
     * saveTitle
     * 
     * This is the method that stores the instructions from the text area into the worksheet object.
     * 
     */
    public void saveInstructions() {
    	
    	worksheet.setInstructions(instructionsInput.getText());
   
    }
    
    @FXML
    /**
     * 
     * saveQuestionInput
     * 
     * This method saves the user question and sub questions (a through e).
     * These inputs are then saved to a MultipleChoiceQuestion object.
     * 
     * @param event the Next button was clicked
     * 
     */
    public void saveQuestionInput(ActionEvent event) {
    	
    	// By default, assume no issues with empty text fields
    	boolean isEmpty = false;
    	
    	//ArrayList to hold temporary question inputs
    	ArrayList<String> tempInput = new ArrayList<String>();
    	
    	// add question A-E to tempInput
    	tempInput.add(questionBox.getText());

    	// instantiate a new MultipleChoiceQuestion object
    	MultipleChoiceQuestion mcq = new MultipleChoiceQuestion(tempInput.get(0), worksheet.getQuestionSet().getNumChoices());
    	
    	// retrieve all the answer choices to store in temporary ArrayList
    	tempInput.add(questionA.getText());
    	tempInput.add(questionB.getText());
    	tempInput.add(questionC.getText());
    	tempInput.add(questionD.getText());
    	tempInput.add(questionE.getText());
    	
    	// Code motion optimization
    	int loopBound = worksheet.getQuestionSet().getNumChoices() + 1;
    	
    	// add the questions to the set while checking for empty input (show error if empty input)
    	for(int i = 1; i < loopBound; i++)
    	{
    	
    		// text field is empty
    		if(tempInput.get(i).equals(""))
    		{ 
    		
    			isEmpty = true; // a text field was empty
    			break; // exit the for loop--questions are only added if there are the proper number of questions
    		
    		}
    		else
    		{
    			
    			// add the choice to the MultipleChoiceQuestion
    			mcq.addChoice(tempInput.get(i));
    			
    		}
    	}
        
    	// go back and check if any text box was empty
    	if(isEmpty == true)
    	{ 
    		
    		warningMessage.setText("ERROR: Please fill in all the boxes.");
    	
    	}
    	else
    	{
    		
    		// add the letter plus dot
    		int letter = (int)'a';
    		for(int j = 0; j < mcq.getMultipleChoices().size(); j++)
    		{
    			
    			mcq.getMultipleChoices().set(j, (char)(letter + j) + ". " + mcq.getMultipleChoices().get(j));
    			
    		}
    		
    		// add the entire question
    		worksheet.getQuestionSet().addQuestion((mcq));
    		
    		// go to the next question
    		nextQuestion(event);
    		
    	}
    }
    
    @FXML
    /**
     * 
     * nextQuestion
     * 
     * This method checks to see if there are any questions left.
     * If there are, it will clear the current question input and increase the question label counter.
     * 
     * @param event the Next button was clicked, saveQuestionInput fired, saveQuestionInput called nextQuestion
     */
    public void nextQuestion(ActionEvent event) {
    
    	// find which question user is on
    	int curQuestion = Integer.parseInt(qLabelMain.getText().substring(1, 2));
    		
    	// if the question user is on  fits within the number of questions they specified, then go for another question
    	if(curQuestion < worksheet.getQuestionSet().getNumQuestions()) {

    		// update question label
    		qLabelMain.setText("Q" + (curQuestion + 1));

    		// clear every text box
    		questionBox.clear();
    		questionA.clear();
    		questionB.clear();
    		questionC.clear();
    		questionD.clear();
    		questionE.clear();
    		
    	}
    	else {
    	
    		// if there are no questions left, go to the next scene
    		goToPDFScene(event);
    	
    	}
    }
    
    @FXML
    /**
     * 
     * goToSecondInput
     * 
     * This is the method that will send the user to the scene after title. It will conditionally select whether to send the
     * user to Instructions.fxml or QuestionInput.fxml, depending on which options the user selected.
     * 
     * @param event the next button was clicked in Title.fxml
     */
    void goToSecondInput(ActionEvent event) {

    	saveTitle();
    	
    	String fileName = null; // the name of the next fxml file
    	
    	// decide what the name of the next file is based on the options the user selected
    	if(worksheet.getOptions().getHasInstructions() == true)
    		fileName = "InstructionsInput";
    	else
    		fileName = "QuestionInput";
    	
    	String title = separateCamelCase(fileName); // format the String to make a title for next window
    	
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
    
    @FXML
    /**
     * 
     * goToQuestionInput
     * 
     * This is the method that will send the user to QuestionInput.fxml. It is an unconditional change.
     * 
     * @param event the next button was clicked in Instructions.fxml
     */
    void goToQuestionInput(ActionEvent event) {

    	saveInstructions();
    	
    	try {
    		
    		URL url = new File("src/QuestionInput.fxml").toURI().toURL();
    		Parent loadedFxml = FXMLLoader.load(url);
    		Scene scene = ((Node) event.getSource()).getScene();
    		scene.setRoot(loadedFxml);
    		Stage stg = (Stage)scene.getWindow(); 
    		stg.setTitle("Question Input");
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
     * goToPDFScene
     * 
     * This is the method that sends the user to PDFScene.fxml.
     * 
     * @param event the next button was clicked in QuestionInput.fxml
     */
    public void goToPDFScene(ActionEvent event) {

    	try {
    		
    		URL url = new File("src/PDFScene.fxml").toURI().toURL();
    		Parent loadedFxml = FXMLLoader.load(url);
    		Scene scene = ((Node) event.getSource()).getScene();
    		scene.setRoot(loadedFxml);
    		Stage stg = (Stage)scene.getWindow(); 
    		stg.setTitle("Generate PDF");
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
    
	
}
