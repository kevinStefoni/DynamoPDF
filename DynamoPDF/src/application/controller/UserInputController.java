package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    
    @FXML
    void goToPDFGenerate(ActionEvent event) {


    	try {
    		
    		URL url = new File("src/GeneratePDF.fxml").toURI().toURL();
    		background = FXMLLoader.load(url);
    		Scene scene = new Scene(background);
    		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    		window.setTitle("Options");
    		window.setScene(scene);
    		window.show();
    		
    	}
    	catch(IOException ioe)
    	{
    		
    		ioe.printStackTrace();
    		
    	}
    	
    }
    
	
}
