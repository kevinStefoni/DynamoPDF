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
	
	/* elements shared for all documents */
	
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
    
    public void initialize()
    {
    	
    }
    
    @FXML
    public void saveTitle() {
    	worksheet.setTitle(titleInput.getText());
    }
    
    @FXML
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
    
	
}
