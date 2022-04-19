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
	 * and passes it into a class that will ultimately create the pdf using the Apache PDF Box API. 
	 * 
	 * @param event the Generate PDF button was pressed
	 */
	void generate(ActionEvent event)
	{

		pdf.generatePDF(worksheet);
		
	}

//    @FXML
//   public void handleSave(ActionEvent event) throws IOException {
//    	Window stage = saveButton.getScene().getWindow();
//    	fc.setTitle("Save PDF File");
//    	fc.setInitialFileName("MyPDF");
//    	fc.getExtensionFilters().addAll(
//    			new ExtensionFilter ("PDF Files", "*.pdf"));    	
//    	try {
//    	File file=fc.showSaveDialog(stage);
//    	//save the chosen directory
//    	fc.setInitialDirectory(file.getParentFile());
//    	String absolute = file.getAbsolutePath();
//    	System.out.println(absolute);
//    	}catch(Exception e) {
//    		e.printStackTrace();
//    	}
//    }
    
    @FXML
    void saveAs(ActionEvent event) throws IOException {
    	
    	Window stage = saveMenuItem.getParentPopup().getOwnerWindow();
    	fc.setTitle("Save PDF File");
    	fc.setInitialFileName("MyPDF");
    	fc.getExtensionFilters().addAll(
    			new ExtensionFilter ("PDF Files", "*.pdf"));    
    	
    	try {
    		
	    	File file=fc.showSaveDialog(stage);
	    	//save the chosen directory
	    	fc.setInitialDirectory(file.getParentFile());
	    	String absolute = file.getAbsolutePath();
	    	//document.save(file.getAbsoluteFile());
	    	//System.out.println(absolute);
	    	
	    	File src = new File("test.pdf");
	    	File dest = new File(absolute);
	    	
	    	Files.copy(src.toPath(), dest.toPath());
	    	
    	}catch(Exception e){ e.printStackTrace();}
    	
    }
    
    @FXML
    void previewPDF(ActionEvent event) {
    	// TODO Open test.pdf so user can see what it will look like
    }

    
}
