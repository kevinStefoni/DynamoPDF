package application.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;

public class PDF{

	private int pageNumber = 0;
	private static float currentY;
	
	/**
	 * 
	 * getPageNumber
	 * 
	 * This is the getter method for pageNumber.
	 * 
	 * @return pageNumber the current page that the PDF is on
	 */
	public int getPageNumber()
	{
		
		return this.pageNumber;
		
	}
	
	/**
	 * 
	 * setPageNumber
	 * 
	 * This is the setter method for pageNumber.
	 * 
	 * @param pageNumber the current page that the PDF is on
	 */
	public void setPageNumber(int pageNumber)
	{
		
		this.pageNumber = pageNumber;
		
	}
	
	public	void generatePDF(Worksheet worksheet)
	{
		
		
		try {
			
			// First, store the font type based on the worksheet object's selected options.
			PDFont font = PDType1Font.TIMES_ROMAN;
			
			if(worksheet.getOptions().getFont() == Options.Fonts.TIMES_NEW_ROMAN)
			{
				
				font = PDType1Font.TIMES_ROMAN;
				
			}
			else if(worksheet.getOptions().getFont() == Options.Fonts.COURIER)
			{
				
				font = PDType1Font.COURIER;
				
			}
			else if(worksheet.getOptions().getFont() == Options.Fonts.HELVETICA)
			{
				
				font = PDType1Font.HELVETICA;
				
			}
			
			// Store the font size in a variable. 
			float fontSize = worksheet.getOptions().getFontSize();
			
			// Create the pdf document and add a new page to it
			PDDocument pdf = new PDDocument();
			PDPage page = new PDPage();
			pdf.addPage(page);

			
			//PDFont font = PDTrueTypeFont.load(pdf, PDDocument.class.getResourceAsStream(
			//	    "/org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf"), WinAnsiEncoding.INSTANCE);
		
			// create the content stream
			PDPageContentStream contentStream = new PDPageContentStream(pdf, pdf.getPage(pageNumber));
			
			// establish margin, width, and initial positions using PDRectangle
			PDRectangle mediabox = page.getMediaBox();
			float margin = 72;
			float width = mediabox.getWidth() - 2 * margin;
			float startX = mediabox.getLowerLeftX() + margin;
			float startY = mediabox.getUpperRightY() - margin;
			currentY = startY;
			
			// display name, name and date, or just date
			if(worksheet.getOptions().getHasName() && !worksheet.getOptions().getHasDate())
				writeStringToPDF(pdf, pdf.getPage(pageNumber), contentStream, font, fontSize, "Name: ____________________", margin, width, startX, currentY);
			if(worksheet.getOptions().getHasDate() && worksheet.getOptions().getHasName())
				writeStringToPDF(pdf, pdf.getPage(pageNumber), contentStream, font, fontSize, "Name: ____________________                                                                   Date: __________", margin, width, startX, currentY );
			else if(worksheet.getOptions().getHasDate() && !worksheet.getOptions().getHasName())
				writeStringToPDF(pdf, pdf.getPage(pageNumber), contentStream, font, fontSize, "Date: __________", margin, width, startX, currentY);
			
			// skip a line
			currentY -=15;
			
			// display the title (left-aligned for simplicity)
			if(worksheet.getOptions().getHasTitle())
			{
			
				writeStringToPDF(pdf, pdf.getPage(pageNumber), contentStream, font, fontSize, worksheet.getTitle(), margin, width, startX, currentY);
				currentY -= 15; // skip another line only if title displayed
				
			}
			
			
			// display the instructions
			if(worksheet.getOptions().getHasInstructions())
			{
				
				writeStringToPDF(pdf, pdf.getPage(pageNumber), contentStream, font, fontSize, worksheet.getInstructions(), margin, width, startX, currentY);
				currentY -= 15; // skip another line only if instructions displayed
				
			}
			
			// loop through each multiple choice question
			for(MultipleChoiceQuestion mcq: worksheet.getQuestionSet().getSetOfQuestions())
			{
			
				//FIXME
				System.out.printf("> %s%n", mcq.getQuestion());
				
				// print the actual question
				writeStringToPDF(pdf, pdf.getPage(pageNumber), contentStream, font, fontSize, mcq.getQuestion(), margin, width, startX, currentY);
				
				// print each answer choice
				for(String choice: mcq.getMultipleChoices())
				{
				
					//FIXME
					System.out.printf("> %s%n", choice);
					writeStringToPDF(pdf, pdf.getPage(pageNumber), contentStream, font, fontSize, choice, margin, width, startX, currentY);
				
				}
			}
            
			// close the content stream
	        contentStream.close();
			
	        // save the pdf in a temporary location within project folder
			pdf.save(new File("test.pdf"));
			
			// close the pdf
			pdf.close();
			
		}
		catch(IOException ioe)
		{
			
			ioe.printStackTrace();
			
		}
	}
	
	public void writeStringToPDF(PDDocument pdf, 
								  PDPage page,
							      PDPageContentStream contentStream,
								  PDFont font,
								  float fontSize,
								  String text,
								  float margin,
								  float width,
								  float startX,
								  float startY
								  )
	{
		
		try {
		
			float leading = 1.5f * fontSize;
			
	        List<String> lines = new ArrayList<String>();
	        int lastSpace = -1;
	        
	        while (text.length() > 0)
	        {
	            int spaceIndex = text.indexOf(' ', lastSpace + 1);
	            
	            if (spaceIndex < 0)
	                spaceIndex = text.length();
	            
	            String subString = text.substring(0, spaceIndex);
	            float size = fontSize * font.getStringWidth(subString) / 1000;
	            
	            if (size > width)
	            {
	                if (lastSpace < 0)
	                    lastSpace = spaceIndex;
	                
	                subString = text.substring(0, lastSpace);
	                lines.add(subString);
	                text = text.substring(lastSpace).trim();
	                lastSpace = -1;
	                
	            }
	            else if (spaceIndex == text.length())
	            {
	            	
	                lines.add(text);
	                text = "";
	                
	            }
	            else
	            {
	            	
	                lastSpace = spaceIndex;
	                
	            }
	            
	        }
	

	       
	        for (String line: lines)
	        {
	            
		        contentStream.beginText();
		        contentStream.setFont(font, fontSize);
		        contentStream.newLineAtOffset(startX, currentY);
	            
	            contentStream.showText(line);
	            contentStream.endText();
	            currentY -=15;
	            
	        }
		}catch(IOException e)
		{
			
			e.printStackTrace();
			
		}

	}
}
