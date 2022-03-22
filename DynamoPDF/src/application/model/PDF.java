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


	
	public	void generatePDF(Worksheet worksheet)
	{
		
		
		try {
			
			PDDocument pdf = new PDDocument();
			PDPage page = new PDPage();
			pdf.addPage(page);
			//PDFont font = PDTrueTypeFont.load(pdf, PDDocument.class.getResourceAsStream(
			//	    "/org/apache/pdfbox/resources/ttf/LiberationSans-Regular.ttf"), WinAnsiEncoding.INSTANCE);
			// PDFont font = PDType1Font.HELVETICA; now also works, because I installed PDFBox 2.0.X, instead of the alpha of 3.0.X.
			
			PDFont font = PDType1Font.TIMES_ROMAN;
			float fontSize = 12;
			
			PDPageContentStream contentStream = new PDPageContentStream(pdf, pdf.getPage(0));
			
			float leading = 1.5f * fontSize;
			PDRectangle mediabox = page.getMediaBox();
			float margin = 72;
			float width = mediabox.getWidth() - 2 * margin;
			float startX = mediabox.getLowerLeftX() + margin;
			float startY = mediabox.getUpperRightY() - margin;
			
			String text = worksheet.getTitle();
			
			List<String> lines = new ArrayList<String>();
			int lastSpace = -1;
			
			while(text.length() > 0)
			{
				
				int spaceIndex = text.indexOf(' ', lastSpace + 1);
				if(spaceIndex < 0)
					spaceIndex = text.length();
				
				String sub = text.substring(0, spaceIndex);
				float size = fontSize * font.getStringWidth(sub) / 1000;
				System.out.printf("'%s' - %f of %f\n", sub, size, width);
				
			}
			
			
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
