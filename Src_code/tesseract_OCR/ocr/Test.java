package tesseract_OCR.ocr;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Test {

	public static void main(String[] args) {
		Tesseract tesseract = new Tesseract();
		try {
			// get the characters in image.png file
			// converting image.png file to pdf file
			// reading pdf file 
			tesseract.setDatapath("C:\\Users\\Admin\\Downloads\\Tess4J\\tessdata");
			// the path of your tessdata folder inside the extracted file
			
			String text = tesseract.doOCR(new File("C:\\Users\\Admin\\Downloads\\Number1.png"));
			
			// path of your image file
			System.out.println(text);
		}
		catch(TesseractException e) {
			e.printStackTrace();
		}
	}
}


