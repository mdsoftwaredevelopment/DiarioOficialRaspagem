package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class ColetaPDF {
	public void raspagem(String path,ArrayList<String> advogados) throws InvalidPasswordException, IOException
	{
		ArrayList<String> processos;
		PDDocument pdf;
		LeituraPag ler = new LeituraPag();
		Buscar carregar = new Buscar();
		SepProcessos separar = new SepProcessos();
		ArrayList<String> processosSeparados = new ArrayList<String>();
		pdf = carregar.PDF(path);	
		processos = separar.processos(pdf);
		XWPFDocument document = new XWPFDocument();
		for(int i=0;i<processos.size();i++)
		{
			if(processos.get(i).contains(advogados.get(0)))
					{			
				XWPFParagraph tmpParagraph = document.createParagraph();
				XWPFRun tmpRun = tmpParagraph.createRun();
				tmpRun.setFontSize(8);
				tmpRun.setText(processos.get(i));
				tmpRun.addCarriageReturn();	
					}
		}
		document.write(new FileOutputStream(new File("C:\\Users\\Dezembro\\Desktop\\Saida.docx")));
		document.close();		
//		System.out.println(processosSeparados);
	}
}

//Severino José da Cunha
