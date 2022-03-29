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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserInputController extends OptionsMenuController{
		

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
    	
    	
    }
    
    @FXML
    void goToPDFGenerate(ActionEvent event) {


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
    
	
}
