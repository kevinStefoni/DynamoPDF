package application.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class PDFSceneController {

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
    void handleSave(ActionEvent event) throws IOException {
    	String pdfName=PDFNameTextArea.getText().toString()+"\n";
    	
    }

}
