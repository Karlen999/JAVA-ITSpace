package apachepoi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

import static org.apache.poi.ss.usermodel.CellType.*;

public class ReadExcelApp {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("G:\\JAVA ITSpace\\src\\main\\resources\\my.xlsx");
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet1 = workbook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();
        for (Row row : sheet1) {
            for (Cell cell : row) {
//                CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
//                System.out.print(cellRef.formatAsString());
//                System.out.print(" - ");

                String cellValue = formatter.formatCellValue(cell);
                System.out.println(cellValue);
            }

        }

        inputStream.close();
    }

    public static void getCellText(Cell cell) {
       // String result ="" ;
        switch (cell.getCellType()) {
            case STRING:
                 cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    cell.getDateCellValue().toString();
                } else {
                    Double.toString(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                Boolean.toString(cell.getBooleanCellValue());
                break;
            case FORMULA:
                cell.getCellFormula();
                break;
            default:
                System.out.println();
        }
     //   return result;
    }
}

