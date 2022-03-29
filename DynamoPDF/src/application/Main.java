package application;
	
import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	/**
	 * 
	 * start
	 * 
	 * This will pull up the MainMenu fxml file. This window will be maximized by default.
	 * The minimum height and width are both 800x800. 
	 * 
	 * @param primaryStage the primary stage on which the window will be set
	 * 
	 */
	public void start(Stage primaryStage) {
		try {
			primaryStage.setMaximized(true);
			primaryStage.setMinHeight(800);
			primaryStage.setMinWidth(800);
			URL url = new File("src/MainMenu.fxml").toURI().toURL();
	    	AnchorPane root = FXMLLoader.load(url);
			Scene scene = new Scene(root,800,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Dynamo PDF");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
