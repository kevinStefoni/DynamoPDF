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
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.Window;

public class PDFController extends UserInputController implements Initializable{
	
		private PDDocument document = new PDDocument();
		
		private PDF pdf = new PDF();
	
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
	    private ScrollBar pDFscrollBar;

	    @FXML
	    private Menu helpMenu;

	    @FXML
	    private Button saveButton;

	    @FXML
	    private Menu fileMenu;

	    @FXML
	    private ScrollBar pageScrollBar;
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
		
		//pdf.generatePDF(worksheet);

		goToPDFScene(event);
		
	}

	    	

	public void intialize(URL location, ResourceBundle resources) {
    	fc.setInitialDirectory(new File("downloads"));

    }
    @FXML
   public void handleSave(ActionEvent event) throws IOException {
    	Window stage =saveButton.getScene().getWindow();
    	fc.setTitle("Save Dialog");
    	fc.setInitialFileName("My PDF");
    	fc.getExtensionFilters().addAll(
    			new ExtensionFilter ("PDF Files", "*.pdf"));
    	
    	try {
    	File file=fc.showSaveDialog(stage);
    	//save the chosen directory
    	fc.setInitialDirectory(file.getParentFile());
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
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
