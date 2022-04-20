package application.controller;

import java.io.File;
import java.nio.file.Files;
import java.io.IOException;

import application.model.PDF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;

public class PDFController extends UserInputController implements Initializable{
	
	@FXML
	private MenuItem saveMenuItem;

	private FileChooser fc= new FileChooser();
	private PDF pdf = new PDF();
	    
	@FXML
	/**
	 * 
	 * generate
	 * 
	 * This is the method that finally takes the completed static worksheet object, with all of the worksheet's information,
	 * and passes it into a class that will ultimately create the PDF using the Apache PDF Box API. 
	 * 
	 * @param event the Generate PDF button was pressed
	 */
	void generate(ActionEvent event)
	{

		pdf.generatePDF(worksheet);
		
	}

    @FXML
    /**
     * 
     * saveAs
     * 
     * This method implements a save as functionality for the user. A File Chooser dialog
     * box will appear that allows the user to name the PDF and save it wherever they want.
     * In reality, the file has already been created and is just copied to that location.
     * 
     * @param event the Save As menu item was clicked
     * @throws IOException
     */
    void saveAs(ActionEvent event) throws IOException {
    	
    	// Create the FileChooser window
    	Window stage = saveMenuItem.getParentPopup().getOwnerWindow();
    	
    	// Set default parameters of the FileChooser
    	fc.setTitle("Save PDF File");
    	fc.setInitialFileName("MyPDF");
    	fc.getExtensionFilters().addAll(
    			new ExtensionFilter ("PDF Files", "*.pdf"));    
    	
    	try {
    		
	    	File file=fc.showSaveDialog(stage);
	    	
	    	//save the chosen directory
	    	fc.setInitialDirectory(file.getParentFile());
	    	String absolute = file.getAbsolutePath();

	    	// store the proper paths
	    	File src = new File("test.pdf");
	    	File dest = new File(absolute);
	    	
	    	// copy from test.pdf in project folder to wherever user wants
	    	Files.copy(src.toPath(), dest.toPath());
	    	
    	}catch(Exception e){ e.printStackTrace();}
    	
    }
    
    @FXML
    void previewPDF(ActionEvent event) {
    	// TODO Open test.pdf so user can see what it will look like
    }
    
    @FXML
    /**
     * 
     * goToExit
     * 
     * This method ends the program.
     * 
     * @param event the user clicked on the Exit menu item 
     */
    void goToExit(ActionEvent event) {

    	// Terminate the program gracefully
    	System.exit(0);
    	
    }


    
}
