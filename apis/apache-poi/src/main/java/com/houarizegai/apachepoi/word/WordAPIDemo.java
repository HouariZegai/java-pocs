
package com.houarizegai.apachepoi.word;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class WordAPIDemo {

    public static void main(String[] args) throws InvalidFormatException {
        try {
            String machineName = System.getProperty("user.name");
            
            FileOutputStream file = new FileOutputStream("C:\\Users\\" + machineName + "\\Downloads\\Documents\\wordFromJava.docx");
            XWPFDocument document = new XWPFDocument();
            XWPFParagraph paragraph = document.createParagraph();
            
            XWPFRun run = paragraph.createRun();
            run.setText("I'm Houari ZEGAI coming from Java !");
            run.addBreak();
            run.setFontFamily("Comic Sans MS");
            run.setBold(true);
            
            XWPFRun run2 = paragraph.createRun();
            run2.setText("Second paragraph");
            run2.setColor("2196f3");
            run2.setFontSize(24);
            run2.setUnderline(UnderlinePatterns.DASHED_HEAVY);
            
            // Adding image
            XWPFRun run3 = paragraph.createRun();
            run3.addPicture(WordAPIDemo.class.getResourceAsStream("/images/dark.jpg"), XWPFDocument.PICTURE_TYPE_JPEG,
                    "houari", Units.toEMU(400), Units.toEMU(200));
            
            // Adding table
            XWPFTable table = document.createTable();
            
            table.setCellMargins(20, 200, 20, 200);
            
            XWPFTableRow row0 = table.getRow(0);
            row0.getCell(0).setText("N°Dos");
            row0.createCell().setText("Nom");
            row0.createCell().setText("Prenom");
            row0.createCell().setText("Date Naissance");
            row0.createCell().setText("Sexe");
            row0.createCell().setText("Club");
            row0.createCell().setText("Code Wilaya");
            row0.createCell().setText("Eq/Ind");
            
            row0.getCell(0).setColor("2196f3");
            row0.getCell(1).setColor("2196f3");
            row0.getCell(2).setColor("2196f3");
            row0.getCell(3).setColor("2196f3");
            row0.getCell(4).setColor("2196f3");
            row0.getCell(5).setColor("2196f3");
            row0.getCell(6).setColor("2196f3");
            row0.getCell(7).setColor("2196f3");
            
            XWPFTableRow row1 = table.createRow();
            row1.getCell(0).setText("001");
            row1.getCell(1).setText("Houari");
            row1.getCell(2).setText("ZEGAI");
            row1.getCell(3).setText("01/01/1996");
            row1.getCell(4).setText("Homme");
            row1.getCell(5).setText("CAAT");
            row1.getCell(6).setText("TIARET");
            row1.getCell(7).setText("E");
            
            XWPFTableRow row2 = table.createRow();
            row2.getCell(0).setText("002");
            row2.getCell(1).setText("Khaled");
            row2.getCell(2).setText("ZEGAI");
            row2.getCell(3).setText("23/09/1968");
            row2.getCell(4).setText("Homme");
            row2.getCell(5).setText("CSST");
            row2.getCell(6).setText("TIARET");
            row2.getCell(7).setText("I");
            
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            
            document.write(file);
            file.close();
            System.out.println("Done !");
            
        } catch (FileNotFoundException e) {
            System.out.println("Error msg: (FileNotFoundException) " + e.getMessage());
        } catch (IOException ex) {
            System.out.println("Error msg: (IOException) " + ex.getMessage());
        }
    }
    
}
