package com.loiane.pdf;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * IText Hello World class
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
public class PDFCreator {

	/**
	 * Creates a PDF document and saves it on a directory.
	 * @param filename the path to the new PDF document
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void createPdf(String filename) throws DocumentException, IOException {
		
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(filename));
		
		document.open();
		document.add(new Paragraph("Hello, World!"));
		document.close();
	}

	/**
	 * Creates a PDF document in Memory - commonly used for download (client-server).
	 * In this method we will create the pdf in memory and we will save it on a
	 * file just for testing.
	 * @param filename the path to the new PDF document
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void createPdfMemory(String filename) throws DocumentException, IOException {
		
		Document document = new Document();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, baos);
		
		document.open();
		document.add(new Paragraph("Hello, World!"));
		document.close();

		// will save it on a file just for testing
		FileOutputStream fos = new FileOutputStream(filename);
		fos.write(baos.toByteArray());
		fos.close();
	}
	
	public static void main(String[] args){
		
		PDFCreator pdfCreator = new PDFCreator();
		
		try {
			pdfCreator.createPdf("HelloWorld.pdf");
			pdfCreator.createPdfMemory("HelloWorldMemory.pdf");
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
