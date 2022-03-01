package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class MainMenuController {

    @FXML
    private AnchorPane root;

    @FXML
    private Label label;

    @FXML
    private Button designButton;
    
    @FXML
    private Button exitButton;
    
    @FXML
    private VBox mainMenuVBox;
    
    @FXML
    void goToDesign(ActionEvent event) {

    	
    	
    }

    @FXML
    void leaveApp(ActionEvent event) {

    	System.exit(0);
    	
    }
    
    


}
