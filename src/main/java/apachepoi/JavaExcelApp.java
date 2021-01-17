package apachepoi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
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
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("poxos");
        Cell cell1 = row.createCell(1);
        cell1.setCellValue("poxosyan");
        Row row1 = sheet.createRow(1);
        Cell cell2 = row1.createCell(0);
        cell2.setCellValue("petros");
        Cell cell3 = row1.createCell(1);
        cell3.setCellValue("petrosyan");


        FileOutputStream outputStream = new FileOutputStream("G:\\JAVA ITSpace\\src\\main\\resources\\my.xlsx");

        workbook.write(outputStream);
        outputStream.close();
    }
}
