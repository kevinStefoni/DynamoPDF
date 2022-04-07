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
			
			PDDocument pdf = new PDDocument();
			PDPage page = new PDPage();
			pdf.addPage(page);

			
			//PDFont font = PDTrueTypeFont.load(pdf, PDDocument.class.getResourceAsStream(
			//	    "/org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf"), WinAnsiEncoding.INSTANCE);
			// PDFont font = PDType1Font.HELVETICA; now also works, because I installed PDFBox 2.0.X, instead of the alpha of 3.0.X.
			
		
			String text = "This is another very long string, ";
			String text2 = "This is the second string. Time to see if it is going to work.";
					
			
			PDPageContentStream contentStream = new PDPageContentStream(pdf, pdf.getPage(pageNumber));
			contentStream.beginText();
			
			PDRectangle mediabox = page.getMediaBox();
			float margin = 72;
			float width = mediabox.getWidth() - 2 * margin;
			float startX = mediabox.getLowerLeftX() + margin;
			float startY = mediabox.getUpperRightY() - margin;
			
			contentStream.beginText();
			
			writeStringToPDF(pdf, page, contentStream, font, fontSize, text, margin, width, startX, startY);
     		writeStringToPDF(pdf, page, contentStream, font, fontSize, text2, margin, width, 0, -15);
			
	        contentStream.endText();
	        contentStream.close();
			
			
			//content offset method is relative, not absolute


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
	            System.out.printf("'%s' - %f of %f\n", subString, size, width);
	            if (size > width)
	            {
	                if (lastSpace < 0)
	                    lastSpace = spaceIndex;
	                subString = text.substring(0, lastSpace);
	                lines.add(subString);
	                text = text.substring(lastSpace).trim();
	                System.out.printf("'%s' is line\n", subString);
	                lastSpace = -1;
	            }
	            else if (spaceIndex == text.length())
	            {
	                lines.add(text);
	                System.out.printf("'%s' is line\n", text);
	                text = "";
	            }
	            else
	            {
	                lastSpace = spaceIndex;
	            }
	        }
	
	        contentStream.setFont(font, fontSize);
	        contentStream.newLineAtOffset(startX, startY);
	        float currentY=startY;
	        for (String line: lines)
	        {
	            currentY -=leading;
	
	            if(currentY<=margin)
	            {
	
	                contentStream.endText(); 
	                contentStream.close();
	                PDPage new_Page = new PDPage();
	                pdf.addPage(new_Page);
	                contentStream = new PDPageContentStream(pdf, new_Page);
	                contentStream.beginText();
	                contentStream.setFont(font, fontSize);
	                contentStream.newLineAtOffset(startX, startY);
	                currentY=startY;
	            }
	            contentStream.showText(line);
	            contentStream.newLineAtOffset(0, -leading);
	        }
		}catch(IOException e)
		{
			
			e.printStackTrace();
			
		}
	}
}
