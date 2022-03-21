package application.controller;

import java.io.IOException;

import application.model.PDF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

public class PDFController extends UserInputController{

    @FXML
    private BorderPane borderPane;

    @FXML
    private MenuBar menuBar;
    
    @FXML
    private TextArea PDFNameTextArea;
    
    @FXML
    private Menu editMenu;

    @FXML
    private Menu helpMenu;

    @FXML
    private Button saveButton;

    @FXML
    private Menu fileMenu;
	
    @FXML
    private AnchorPane generatePDFAnchorPane;

    @FXML
    private Button generatePDFButton;
    
    private PDF pdf = new PDF();

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
		
		pdf.generatePDF(worksheet);
		
	}
	
    @FXML
    void handleSave(ActionEvent event) throws IOException {
    	
    	String pdfName=PDFNameTextArea.getText().toString()+"\n";
    	
    }
	
}
