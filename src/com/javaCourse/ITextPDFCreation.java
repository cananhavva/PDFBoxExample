package com.javaCourse;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ITextPDFCreation {
	
	private static final String PDF_FILE = "C:\\Users\\canan\\eclipse-workspace\\PDFBoxExample\\src\\com\\javaCourse\\iText Example.pdf";
	
	public static void main(String[] args) {
		
		try {
			createPDF();
		} catch (IOException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void createPDF() throws FileNotFoundException, IOException, DocumentException {
		Document pdf = new Document(PageSize.A4, 20, 20, 20, 20);
		System.out.println("PDF created");
		
		try (FileOutputStream fos = new FileOutputStream(ITextPDFCreation.PDF_FILE)) { // i�erik doldurmaca burada
																						// ba�l�yor
			PdfWriter writer = PdfWriter.getInstance(pdf, fos);
			// writer.setEncryption("gizli".getBytes(), "mizli".getBytes(),
			// PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
			pdf.open();
			pdf.add(new Paragraph("bir g�n okula giderken..."));
			pdf.add(new Paragraph("her �eye dikkat ederken..."));
			pdf.add(new Paragraph("bir k�z ��kt� kar��ma..."));
			
			pdf.addAuthor("Bab�r Somer");
			pdf.addCreationDate();
			pdf.addCreator("Automated creation");
			pdf.addTitle("iText ile PDF dosyas� olu�turma");
			pdf.addKeywords("pdf; java; bilgeadam;");
			pdf.close();
			writer.close();
		}
		System.out.println("PDF content written");
	}
}
