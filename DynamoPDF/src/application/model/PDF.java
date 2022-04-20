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
import org.apache.pdfbox.pdmodel.font.PDType1Font;

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
	
	/**
	 * 
	 * generatePDF
	 * 
	 * This is the most important method of the application that finally uses writeStringToPDF to write the PDF.
	 * It formats everything and prints everything from the static worksheet object that was passed along through all
	 * the controller classes using Apache PDF box API.
	 * 
	 * @param worksheet the static worksheet object whose information is to be used to generate a pdf of the worksheet
	 */
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
				writeStringToPDF(pdf, pdf.getPage(pageNumber), contentStream, font, fontSize, margin, width, startX, currentY, 
						"Name: ____________________");
			if(worksheet.getOptions().getHasDate() && worksheet.getOptions().getHasName())
				writeStringToPDF(pdf, pdf.getPage(pageNumber), contentStream, font, fontSize, margin, width, startX, currentY, 
						"Name: ____________________                                                                   Date: __________");
			else if(worksheet.getOptions().getHasDate() && !worksheet.getOptions().getHasName())
				writeStringToPDF(pdf, pdf.getPage(pageNumber), contentStream, font, fontSize, margin, width, startX, currentY,
						"Date: __________");
			
			// skip a line
			currentY -=15;
			
			// display the title (left-aligned for simplicity)
			if(worksheet.getOptions().getHasTitle())
			{
			
				writeStringToPDF(pdf, pdf.getPage(pageNumber), contentStream, font, fontSize, margin, width, startX, currentY,
						worksheet.getTitle());
				currentY -= 5; // skip another line only if title displayed
				
			}
			
			
			// display the instructions
			if(worksheet.getOptions().getHasInstructions())
			{
				
				writeStringToPDF(pdf, pdf.getPage(pageNumber), contentStream, font, fontSize, margin, width, startX, currentY, 
						worksheet.getInstructions());
				currentY -= 10; // skip another line only if instructions displayed
				
			}
			
			int questionTracker = 1; // keep track of which question it is for the sake of numbering the questions
			
			// loop through each multiple choice question
			for(MultipleChoiceQuestion mcq: worksheet.getQuestionSet().getSetOfQuestions())
			{
			
				// print the actual question--if numbered questions, then print it with a number; otherwise, just the question
				if(worksheet.getOptions().getHasNumberedQuestions())
					writeStringToPDF(pdf, pdf.getPage(pageNumber), contentStream, font, fontSize, margin, width, startX, currentY,
							String.valueOf(questionTracker) + ". " + mcq.getQuestion());
				else
					writeStringToPDF(pdf, pdf.getPage(pageNumber), contentStream, font, fontSize, margin, width, startX, currentY,
							mcq.getQuestion());
				
				// print each answer choice
				for(String choice: mcq.getMultipleChoices())
				{

					writeStringToPDF(pdf, pdf.getPage(pageNumber), contentStream, font, fontSize, margin, width, startX, currentY,
							choice);
				
				}
				
				currentY -= 15; // skip another line
				
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
	
	/**
	 * 
	 * writeStringToPDF
	 * 
	 * This method takes a String and prints it to the PDF given the parameters. It removes tabs and deals with newline characters.
	 * It also cuts a String off if it would go over the line and starts a new line. 
	 * 
	 * @param pdf 			  the PDF object
	 * @param page 			  the current page
	 * @param contentStream  the content stream
	 * @param font           the font type
	 * @param fontSize 		  the size of the font
	 * @param margin  		  the page margins
	 * @param width    	 	  the width of the page
	 * @param startX         the starting horizontal position relative offset
	 * @param startY         the starting vertical position relative offset
	 * @param text           the String that is to be printed
	 */
	public void writeStringToPDF(PDDocument pdf, 
								  PDPage page,
							      PDPageContentStream contentStream,
								  PDFont font,
								  float fontSize,
								  float margin,
								  float width,
								  float startX,
								  float startY,
								  String text
								  )
	{
		
		try {
		
	        List<String> lines = new ArrayList<String>(); // this will store all of the actual lines that are to be printed
	        int lastSpace = -1; // the last space in the line
	        
	        text = text.replace("\t", ""); // remove tabs
	        
	        // Work around newline characters, because they aren't included in the character encoding being used
	        String[] artificialLines = text.split("[\n]");
	        
	        // Loop through all of the tokens derived from splitting the text string along the newline delimiter
	        for(int k = 0; k < artificialLines.length; k++)
	        {
		        
	        	// Go as long as there is still something left in the line
		        while(artificialLines[k].length() > 0)
		        {
		        	
		        	// find the index of the space that will terminate the substring, starting at the previous space
		            int spaceIndex = artificialLines[k].indexOf(' ', lastSpace + 1);
		            
		            // if there isn't a space available, then cut the String off at the end of the String
		            if(spaceIndex < 0)
		                spaceIndex = artificialLines[k].length();
		            
		            // create the substring, going from the start of the String to the index of the last space before the natural line break
		            String subString = artificialLines[k].substring(0, spaceIndex);
		            
		            // calculate the size of the line
		            float size = fontSize * font.getStringWidth(subString) / 1000;
		            
		            // if the size of the line is greater than the maximum width of a line, then need to introduce a natural line break
		            if(size > width)
		            {
		            	
		                if(lastSpace < 0)
		                    lastSpace = spaceIndex;
		                
		                // update the substring
		                subString = artificialLines[k].substring(0, lastSpace);
		                
		                // add the substring to the ArrayList of lines
		                lines.add(subString);
		                
		                // update the entire string that is to be added and trim it
		                artificialLines[k] = artificialLines[k].substring(lastSpace).trim();
		                
		                // reset lastSpace
		                lastSpace = -1;
		                
		            }
		            else if(spaceIndex == artificialLines[k].length())
		            {
		            	
		            	// if it doesn't have to overflow into another line, but is equal to the line, then just add it as a line.
		                lines.add(artificialLines[k]);
		                
		                // reset the String
		                artificialLines[k] = "";
		                
		            }
		            else
		            {
		            	
		                lastSpace = spaceIndex;
		                
		            }
		            
		        }
	
	        }
	       
	        // looping through every line that is to be in the pdf
	        for(String line: lines)
	        {
	            
	        	// begin the text, set the font, set the position
		        contentStream.beginText();
		        contentStream.setFont(font, fontSize);
		        contentStream.newLineAtOffset(startX, currentY);
	            
		        // display the text and then end the text
	            contentStream.showText(line);
	            contentStream.endText();
	            
	            currentY -=15; // skip another line
	            
	        }
		}catch(IOException e){ e.printStackTrace(); }

	}
	
}
