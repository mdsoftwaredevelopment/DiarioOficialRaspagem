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
		processos = pdfString.split("Processo N�");
		for(int i=1;i<processos.length;i++)
		{
			processos[i] = processos[i].replaceAll("Processo N�", "");
			processos[i] = "Processo N�" + processos[i];
			if(processos[i].contains("SUM�RIO"))
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
