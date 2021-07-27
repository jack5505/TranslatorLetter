package uzb.transfer.letter.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class GenerateWord {

    //Todo make change letter to other one
    //Todo make change to new in here
   public static void changeLetter (String path){
        try {
            XWPFDocument document = new XWPFDocument(OPCPackage.open(new File(path)));
            for (XWPFParagraph p : document.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        System.out.println(text);

                       /* if (text != null && text.contains("needle")) {
                            text = text.replace("needle", "haystack");
                            r.setText(text, 0);
                        }*/


                    }
                }
            }
            for (XWPFTable tbl : document.getTables()) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                                String text = r.getText(0);
                                /*if (text != null && text.contains("needle")) {
                                    text = text.replace("needle", "haystack");
                                    r.setText(text,0);
                                }*/

                            }
                        }
                    }
                }
            }
            document.write(new FileOutputStream("output.docx"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
    }
}
