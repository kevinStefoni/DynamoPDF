package application.model;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;

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
			
			if(worksheet.getOptions().getHasName())
				contentStream.showText("Name: _____________________________________                                                     ");
			
			if(worksheet.getOptions().getHasDate())
				contentStream.showText("Date: __________");
			
			contentStream.newLine();
			contentStream.showText("1. What is 2 + 2?");
			
			contentStream.endText();
			contentStream.close();
			// insert pdf stuff here
			
			pdf.save("test.pdf");
			
			//pdf.save(worksheet.getFileName());
			pdf.close();
			
		}
		catch(IOException ioe)
		{
			
			ioe.printStackTrace();
			
		}
	}
	
	
}
