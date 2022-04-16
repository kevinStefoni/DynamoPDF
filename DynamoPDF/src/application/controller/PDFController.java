package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.pdfbox.pdmodel.PDDocument;

import application.model.PDF;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;

public class PDFController extends UserInputController implements Initializable{
	
	private PDF pdf = new PDF();
	
	@FXML
	private MenuBar menuBar;

	@FXML
    private Menu editMenu;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private MenuItem menuItemAbout;

    @FXML
    private AnchorPane anchorPane;

	@FXML
	private MenuItem saveMenuItem;

	@FXML
	private MenuItem menuClose;

    @FXML
    private Menu helpMenu;

	@FXML
	private MenuItem menuItemEdit;

	@FXML
	private Menu fileMenu;

	FileChooser fc= new FileChooser();
	    
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
    void saveMenuItem(ActionEvent event) throws IOException {
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
    	System.out.println(absolute);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
}
