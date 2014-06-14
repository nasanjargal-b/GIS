package com.monsource.geotsenoz.devider.coordinate;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by nasanjargal on 5/14/14.
 */
public class MainClass {
    public static void main(String[] args) throws IOException {
        String PATH = "/home/nasanjargal/Downloads/baishin koordinat";

        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(PATH + ".xlsx"));

        XSSFSheet sheet = workbook.getSheetAt(0);

        int rowNum = 1;
        int rowX = 2;
        int rowY = rowX + 1;

        for (Row row : sheet) {

            NumberFormat format = new DecimalFormat("0.00");

            String value = row.getCell(rowNum).getStringCellValue().replaceAll(" ", "");
            if (value.contains("X=")) {
                String[] values = value.split("\n");

                String x = "";
                String y = "";

                for (String val : values) {
                    if (!val.contains("X=")) continue;

                    val = val.replace("X=", "").replace("Y=", " ").replace("Z=", " ");
                    String[] coordinate = val.split(" ");
                    x += format.format(Double.parseDouble(coordinate[0])) + "\n";
                    y += format.format(Double.parseDouble(coordinate[1])) + "\n";
                }

                row.createCell(rowX).setCellValue(x);
                row.createCell(rowY).setCellValue(y);

            }
        }

        workbook.write(new FileOutputStream(PATH + "-DIVIDED.xlsx"));
    }
}
