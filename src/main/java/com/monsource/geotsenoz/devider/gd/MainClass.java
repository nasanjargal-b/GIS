package com.monsource.geotsenoz.devider.gd;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by nasanjargal on 5/12/2014.
 */
public class MainClass {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\nasanjargal\\Desktop\\test\\Zavhan_hiliin_tsesiin jagsaalt.xlsx"));

        XSSFSheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            String valueB = row.getCell(7).getStringCellValue();
            String valueL = row.getCell(10).getStringCellValue();
            if (!valueB.matches("[0-9°'\" ]+") && !valueL.matches("[0-9°'\" ]+")) continue;
            String[] valuesB = valueB.split(" ");
            String[] valuesL = valueL.split(" ");

            try {

                int columnIndex = 7;
                row.getCell(columnIndex + 0).setCellValue(valuesB[0]);
                row.getCell(columnIndex + 1).setCellValue(valuesB[1]);
                row.getCell(columnIndex + 2).setCellValue(valuesB[2]);

                row.getCell(columnIndex + 3).setCellValue(valuesL[0]);
                row.getCell(columnIndex + 4).setCellValue(valuesL[1]);
                row.getCell(columnIndex + 5).setCellValue(valuesL[2]);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("ERROR ROW : " + row.getRowNum());
            }
        }

        workbook.write(new FileOutputStream("C:\\Users\\nasanjargal\\Desktop\\test\\Zavhan_hiliin_tsesiin jagsaalt-DIVIDED.xlsx"));
    }
}
