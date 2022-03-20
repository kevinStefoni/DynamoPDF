package application.model;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.encoding.Type1Encoding;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;

import application.controller.UserInputController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class PDF{


	
	public	void generatePDF(Worksheet worksheet)
	{
		
		
		try {
			
			PDDocument pdf = new PDDocument();
			pdf.addPage(new PDPage());
			PDFont font = PDTrueTypeFont.load(pdf, PDDocument.class.getResourceAsStream(
				    "/org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf"), WinAnsiEncoding.INSTANCE);
			
			PDPageContentStream contentStream = new PDPageContentStream(pdf, pdf.getPage(0));
			contentStream.beginText();
			contentStream.setFont(font, 12);
			contentStream.newLineAtOffset(25, 725);
			contentStream.showText("Name: ___________________");
			contentStream.endText();
			// insert pdf stuff here
			
			pdf.save("test.pdf");
			
			//pdf.save(worksheet.getFileName());
			contentStream.close();
			pdf.close();
			
		}
		catch(IOException ioe)
		{
			
			ioe.printStackTrace();
			
		}
	}
	
	
}
