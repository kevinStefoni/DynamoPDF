package application.controller;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import application.model.Worksheet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuController {

	public static Worksheet worksheet = new Worksheet();
    
    @FXML
    /**
     * 
     * goToOptionsMenu
     * 
     * This method makes it so that if the user clicks on the DESIGN button in the main menu, then they
     * will be taken to the options menu. This method ensures that the maximization, position, whether it is full screen,
     * and size of the window will persist. It also ensures that the minimum height and width are both 800, to prevent user from
     * shrinking window to such a small size that there are formatting issues visible.
     * 
     * @param event	       the ActionEvent that happens when DESIGN button is clicked
     * @throws IOException if an input or output exception occurs
     * 
     * 
     */
    void goToOptionsMenu(ActionEvent event) throws IOException{

    	try {
    	
    		URL url = new File("src/OptionsMenu.fxml").toURI().toURL();
    		Parent loadedFxml = FXMLLoader.load(url);
    		Scene scene = ((Node) event.getSource()).getScene();
    		scene.setRoot(loadedFxml);
    		Stage stg = (Stage)scene.getWindow(); 
    		stg.setTitle("Options");
    		stg.setHeight(stg.getHeight());
    		stg.setWidth(stg.getWidth());
    		stg.setX(stg.getX());
    		stg.setY(stg.getY());
    		stg.setMaximized(stg.isMaximized());
    		stg.setFullScreen(stg.isFullScreen());
			stg.setMinHeight(800);
			stg.setMinWidth(800);
    		
    	}
    	catch(IOException e)
    	{
    		
    		e.printStackTrace();
    		
    	}
    		
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
