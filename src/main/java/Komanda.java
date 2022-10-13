import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.PatternDocument;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

public class Komanda {
     public Komanda (String str) throws IOException {
         XSSFWorkbook Book = new XSSFWorkbook(new FileInputStream(str));
         XSSFSheet list = Book.getSheetAt(0);
         Pattern shablon = Pattern.compile("^(\\d{1}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{2}[\\s.-]?\\d{2}$");
         FileWriter telephone = new FileWriter("D:\\java\\number\\text.txt");
            for (int i = 0;i < list.getLastRowNum();i++){
                String stroca = String.valueOf(list.getRow(i).getCell(0));
                if (stroca.matches(String.valueOf(shablon)) ){
                    telephone.write(stroca + "\n" );
                    telephone.flush();
                }
            }
    }
}
