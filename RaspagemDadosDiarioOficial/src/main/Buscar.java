package main;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

public class Buscar {
	
	public PDDocument PDF(String path) throws InvalidPasswordException, IOException
	{
		CarregarPDF carregar = new CarregarPDF();
		PDDocument pdf = carregar.path(path);
		
		return pdf;
	}

}
