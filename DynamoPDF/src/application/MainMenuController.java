package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    /**
     * 
     * goToOptionsMenu
     * 
     * This method makes it so that if the user clicks on the DESIGN button in the main menu, then they
     * will be taken to the options menu.
     * 
     * @param event	       the ActionEvent that happens when DESIGN button is clicked
     * @throws IOException if an input or output exception occurs
     * 
     * 
     */
    void goToOptionsMenu(ActionEvent event) throws IOException{

    		root = FXMLLoader.load(getClass().getResource("OptionsMenu.fxml"));
    		Scene scene = new Scene(root);
    		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    		window.setScene(scene);
    		window.show();
    		
    }

    @FXML
    /**
     * 
     * goToExit
     * 
     * This method makes it so that when user clicks the EXIT button in the main menu, the application will close.
     * 
     * @param event the ActionEvent that happens when the EXIT button is clicked
     * 
     */
    void goToExit(ActionEvent event) {

    	System.exit(0);
    	
    }
    
    


}
