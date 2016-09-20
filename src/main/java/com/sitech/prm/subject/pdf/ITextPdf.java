package com.sitech.prm.subject.pdf;

import java.io.FileOutputStream;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ITextPdf {

	/**
	 * <p>Discription:[方法功能中文描述]</p>
	 * @param args
	 * @author:孙耀宗
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Document document = new Document(PageSize.A4, 0, 0, 0, 0); 
		try {
			//PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\\\temp\\Helloworld.PDF"));
			//writer.setEncryption(true, "123", "456", 0);
			
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\\\temp\\Helloworld.PDF"));
			writer.setEncryption("123".getBytes(), "456".getBytes(), PdfWriter.ALLOW_PRINTING, PdfWriter.STANDARD_ENCRYPTION_40);
		        writer.createXmpMetadata();
			
            document.open(); 
            
			
			

	        
	        Paragraph title1 = new Paragraph("Chapter 1", 
	        FontFactory.getFont("宋体",18, Font.BOLDITALIC, new CMYKColor(0, 255, 255,17)));
	        Chapter chapter1 = new Chapter(title1, 1);
	        chapter1.setNumberDepth(0);
	        
	        
	        Paragraph title11 = new Paragraph("This is Section 1 in Chapter 1", 
	        		FontFactory.getFont("宋体", 16, Font.BOLD, new CMYKColor(0, 255, 255,17)));
	        Section section1 = chapter1.addSection(title11);
	        Paragraph someSectionText = new Paragraph("在网上搜了一下iText的东东，简单的整理了一个Demo，解决了中文乱码问题,这里不贴链接了 网上搜一下就行了");
	        section1.add(someSectionText);
	        someSectionText = new Paragraph("Following is a 3 X 2 table.");
	        section1.add(someSectionText);
	        
	        
	        
	        PdfPTable t = new PdfPTable(12);
	        t.setSpacingBefore(5f);
	        t.setSpacingAfter(5f);
	        //t.setWidths(new float[] { 0.4f, 0.25f, 0.25f, 0.25f });  
	        
	        PdfPCell c1 = new PdfPCell(new Phrase("Header1",FontFactory.getFont("宋体", 16, Font.BOLD, new CMYKColor(0, 255, 255,17))));  
	        PdfPCell c2 = new PdfPCell(new Phrase("Header2"));
	        PdfPCell c3 = new PdfPCell(new Phrase("Header3"));
	        PdfPCell c4 = new PdfPCell(new Phrase("Header4"));
	        PdfPCell c5 = new PdfPCell(new Phrase("Header5"));
	        PdfPCell c6 = new PdfPCell(new Phrase("Header6"));
	        PdfPCell c7 = new PdfPCell(new Phrase("Header7"));
	        PdfPCell c8 = new PdfPCell(new Phrase("Header8"));
	        PdfPCell c9 = new PdfPCell(new Phrase("Header9"));
	        PdfPCell c10 = new PdfPCell(new Phrase("Header10"));
	        PdfPCell c11 = new PdfPCell(new Phrase("Header11"));
	        PdfPCell c12 = new PdfPCell(new Phrase("Header12"));
	        
	        PdfPRow rowHeader = new PdfPRow(new PdfPCell[]{c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12});
	        t.getRows().add(rowHeader);
	        t.completeRow();
	        t.setHeaderRows(0);
	        
	        PdfPCell [] cells = null;
	        for(int i=0;i<100;i++){
	        	cells = new PdfPCell[]{new PdfPCell(new Phrase("a"+i))
	        		,new PdfPCell(new Phrase("b"+i))
		        	,new PdfPCell(new Phrase("c"+i))
	        	    ,new PdfPCell(new Phrase("d"+i))
	        	 	,new PdfPCell(new Phrase("e"+i))
	        		,new PdfPCell(new Phrase("StringBuffer strBuff = new StringBuffer()"+i))
		        	,new PdfPCell(new Phrase("g"+i))
		        	,new PdfPCell(new Phrase("StringBuffer strBuff = new StringBuffer()"+i))
		        	,new PdfPCell(new Phrase())
		        	,new PdfPCell(new Phrase("setHorizontalAlignment(Element.ALIGN_LEFT);"+i))
		        	,new PdfPCell(new Phrase("k"+i))
		        	,new PdfPCell(new Phrase("l"+i))
	        	};
	        	t.getRows().add(new PdfPRow(cells));
	        }
	        t.completeRow();
	        t.setHeaderRows(1);
	        section1.add(t);
	        //document.add(t);
	        
	        List l = new List(true, false, 10);

	        l.add(new ListItem("First item of list"));

	        l.add(new ListItem("Second item of list"));

	        section1.add(l);
	        
	        document.add(t);
	        document.add(chapter1);
	        document.add(new Paragraph("Hello World")); 
			
			 Anchor anchorTarget = new Anchor("First page of the document.");
			    anchorTarget.setName("BackToTop");
			    Paragraph paragraph1 = new Paragraph();
			    paragraph1.setSpacingBefore(50);
			    paragraph1.add(anchorTarget);
			    document.add(paragraph1);

			    document.add(new Paragraph("Some more text on the first page with different color and font type.",
					FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,	new CMYKColor(0, 255, 0, 0))));
		
			document.close(); 
			writer.close();
			System.out.println((System.currentTimeMillis()-startTime)/1000);
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
