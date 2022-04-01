package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserInputController extends OptionsMenuController {
	
	/* elements shared for all input fxml files */
	
    @FXML
    private AnchorPane background;
    
    @FXML
    private Button nextButton;
    
	
	/* titleInput.fxml */
	
	@FXML
	private Label titleLabel;
	
	@FXML
	private TextField titleInput;
	
    
	/* instructionsInput.fxml */
	
	@FXML
	private Label instructionsLabel;
	
	@FXML
	private TextArea instructionsInput;
	
	
    /* questionInput.fxml */
    
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
    
    //end of FXML elements
    
    @FXML
    public void saveTitle() {
    	worksheet.setTitle(titleInput.getText());
    }
    
    @FXML
    /**
     * 
     * goToPDFGenerate
     * 
     * This is the method that sends the user to GeneratePDF.fxml.
     * 
     * @param event the next button was clicked in QuestionInput.fxml
     */
    public void goToPDFGenerate(ActionEvent event) {

    	try {
    		
    		URL url = new File("src/GeneratePDF.fxml").toURI().toURL();
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
    
	
}
