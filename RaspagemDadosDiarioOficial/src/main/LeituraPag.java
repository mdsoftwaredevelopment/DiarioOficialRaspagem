package main;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class LeituraPag 
{
	public ArrayList<String> separar(PDDocument pdf,int pag) throws IOException
	{
		ArrayList<String> paginas= new ArrayList<String>();
		PDFTextStripper pdfStripper = new PDFTextStripper();
		pdfStripper.setStartPage(pag);
		pdfStripper.setEndPage(pag);
		String pagcompleta = pdfStripper.getText(pdf);
		pdfStripper.setStartPage(pag+1);
		pdfStripper.setEndPage(pag+1);
		String pagprox = pdfStripper.getText(pdf);		
		paginas.add(pagcompleta);
		paginas.add(pagprox);
		
		return paginas;
	}
}
