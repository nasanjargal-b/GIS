package com.monsource.geotsenoz.report.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by nasanjargal on 6/16/14.
 */
public class BarilgaWorkbook extends XSSFWorkbook {

    public BarilgaWorkbook() {

        Sheet sheet = this.createSheet();
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("dugaar");
        row.createCell(1).setCellValue("dsh_dmtr");
        row.createCell(2).setCellValue("dsh_urt");
        row.createCell(3).setCellValue("dsh_eutsg");
        row.createCell(4).setCellValue("dsh_shd");
        row.createCell(5).setCellValue("tsush_dmtr");
        row.createCell(6).setCellValue("tsush_urt");
        row.createCell(7).setCellValue("tsush_eh");
        row.createCell(8).setCellValue("tsush_shd");
        row.createCell(9).setCellValue("bush_dmtr");
        row.createCell(10).setCellValue("bush_urt");
        row.createCell(11).setCellValue("bush_hudag");
        row.createCell(12).setCellValue("bush_shd");

    }
}
