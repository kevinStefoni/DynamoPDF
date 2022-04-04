package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

import org.apache.pdfbox.pdmodel.PDDocument;

import application.model.PDF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PDFController extends UserInputController{
	
	 	@FXML
	    private ScrollBar scrollBar;

	    @FXML
	    private MenuBar menuBar;

	    @FXML
	    private Menu editMenu;

	    @FXML
	    private TextArea tempTextArea;

	    @FXML
	    private BorderPane mainBorderPane;

	    @FXML
	    private AnchorPane anchorPane;

	    @FXML
	    private TextField saveTextField;

	    @FXML
	    private Menu helpMenu;

	    @FXML
	    private Button saveButton;

	    @FXML
	    private Label pdfNameLabel;

	    @FXML
	    private Menu fileMenu;

	@FXML
	/**
	 * 
	 * generate
	 * 
	 * This is the method that finally takes the completed static worksheet object, with all of the worksheet's information,
	 * and passes it into a class that will ultimately create the pdf using the Apache PDF Box API. 
	 * 
	 * @param event the Generate PDF button was pressed
	 */
	void generate(ActionEvent event)
	{
		
		//pdf.generatePDF(worksheet);
		goToPDFScene(event);
		
	}
	
    @FXML
    void handleSave(ActionEvent event) throws IOException {
    	FileChooser fc = new FileChooser();
    	//Alert that tells user if PDF was created successfully or not.
    	Alert a = new Alert(AlertType.NONE);
    	//Creating PDF Document
    	PDDocument document = new PDDocument();
    	//Using System.getProperty() to find the users home user file in the off change it's not the default C: drive
    	String home = System.getProperty("user.home");
    	//getting path and storing it user's Downloads folder
    	File file = new File(home+"/Downloads/" + saveTextField.getText() + ".pdf");
    	
    	//Saving file
    	document.save(file);
    	
    	if (file.isFile()) {
    		a.setAlertType(AlertType.CONFIRMATION);
    		a.setHeaderText("PDF Created!");
    		a.show();
    	}
    	else{
    		a.setAlertType(AlertType.ERROR);
    		a.setHeaderText("Error: DynamoPDF was unable to create PDF");
    		a.show();
    	}
    	document.close();
    	
    }
    
    void goToPDFScene(ActionEvent event)
    {

    	try {
    		
    		URL url = new File("src/PDFScene.fxml").toURI().toURL();
    		Parent loadedFxml = FXMLLoader.load(url);
    		Scene scene = ((Node) event.getSource()).getScene();
    		scene.setRoot(loadedFxml);
    		Stage stg = (Stage)scene.getWindow(); 
    		stg.setTitle("Preview");
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
