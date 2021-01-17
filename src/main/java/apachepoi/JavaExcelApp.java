package apachepoi;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaExcelApp {
    public static void main(String[] args) throws IOException {

        Workbook workbook =new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("mySheet");
        FileOutputStream outputStream = new FileOutputStream("G:\\JAVA ITSpace\\src\\main\\resources\\my.xlsx");

        workbook.write(outputStream);
        outputStream.close();
    }
}
