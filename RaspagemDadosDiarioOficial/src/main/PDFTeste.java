package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFTeste {
	public static void  main (String[] args) throws InvalidPasswordException, IOException
	{	
		int numPag;
		ArrayList<String> processos;
		PDDocument pdf;
		LeituraPag ler = new LeituraPag();
		Buscar carregar = new Buscar();
		SepProcessos separar = new SepProcessos();
		pdf = carregar.PDF("C:\\Users\\Dezembro\\Documents\\Diario_J_TST.pdf");
		numPag = pdf.getNumberOfPages();		
//		paginasCache = ler.separar(pdf, 3);
		processos = separar.processos(pdf);
		for(int i=0;i<processos.size();i++)
		{
			System.out.println("Processo número "+i+" \n\n"+processos.get(i)+"\n\n");
		}
		
//
//		File file = new File("C:\\Users\\Dezembro\\Documents\\Diario_J_TST.pdf"); 
//		PDDocument document = PDDocument.load(file);
//		PDFTextStripper pdfStripper = new PDFTextStripper();
//		pdfStripper.setStartPage( 3 );
//		pdfStripper.setEndPage( 4 );
//		String text = pdfStripper.getText(document);
//		System.out.println(text);
		
//		JFileChooser fileChooser = new JFileChooser();
//		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
//		int result = fileChooser.showOpenDialog(getParent());
//		if (result == JFileChooser.APPROVE_OPTION) 
//		{				
//			File selectedFile = fileChooser.getSelectedFile();
//			String path = selectedFile.getAbsolutePath();
//			path = path.replace(File.separator, "//");
//			System.out.println(path);
//			
//		}
	}
}
