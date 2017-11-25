package main;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

public class CarregarPDF 
{
	public PDDocument path(String caminho) throws InvalidPasswordException, IOException
	{
		File pdf = new File(caminho);
		PDDocument pdfCache = PDDocument.load(pdf);
		return pdfCache;
	}
}
