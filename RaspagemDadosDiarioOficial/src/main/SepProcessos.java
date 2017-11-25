package main;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class SepProcessos {
	
	public ArrayList<String> processos(PDDocument pdf) throws IOException
	{
		PDFTextStripper pdfStripper = new PDFTextStripper();
		String pdfString = pdfStripper.getText(pdf);
		String[] processos;
		ArrayList<String> processosArray = new ArrayList<String>();
		processos = pdfString.split("Processo Nº");
		for(int i=1;i<processos.length;i++)
		{
			processos[i] = processos[i].replaceAll("Processo Nº", "");
			processos[i] = "Processo Nº" + processos[i];
			if(processos[i].contains("SUMÁRIO"))
			{
				processos[i] = "";
			}
		}
		processos[0] = "";
		
		for(int i=0;i<processos.length;i++)
		{
			processosArray.add(processos[i]);
		}		
		return processosArray;
	}	
}
