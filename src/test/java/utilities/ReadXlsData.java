package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadXlsData {
    public static void main(String[] args) throws IOException {
        ReadXlsData rxd = new ReadXlsData();
        rxd.getData("login");
    }

    public String[][] getData(String excelSheetName) throws IOException {
        File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");
        FileInputStream fis = new FileInputStream(f);

        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet(excelSheetName);

        int totalRows = sheet.getLastRowNum();
        int totalCols = sheet.getRow(0).getLastCellNum();

        DataFormatter format = new DataFormatter();
        String[][] testData = new String[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                testData[i - 1][j] = format.formatCellValue(sheet.getRow(i).getCell(j));
            }
        }

        fis.close();
        return testData;
    }
}