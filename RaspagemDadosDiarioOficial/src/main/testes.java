package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class testes {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		XWPFDocument document = new XWPFDocument();
		XWPFParagraph tmpParagraph = document.createParagraph();
		XWPFRun tmpRun = tmpParagraph.createRun();
		tmpRun.setText("AAAAA");
		tmpRun.setFontSize(12);
		document.write(new FileOutputStream(new File("C:\\Users\\Dezembro\\Desktop\\teste.docx")));
		document.close();

	}

}
