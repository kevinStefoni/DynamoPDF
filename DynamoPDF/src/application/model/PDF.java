package application.model;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

import application.controller.UserInputController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class PDF{


	
	public	void generatePDF(Worksheet worksheet)
	{
		
		PDDocument pdf = new PDDocument();
		
		try {
			
			pdf.save("newpdf");
			
		}
		catch(IOException ioe)
		{
			
			ioe.printStackTrace();
			
		}
	}
	
	
}
