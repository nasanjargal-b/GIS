package com.monsource.geotsenoz.report.excel;

import com.monsource.geotsenoz.data.entity.HudagEntity;
import com.monsource.geotsenoz.data.entity.ShugamHooloiEntity;
import com.monsource.geotsenoz.data.entity.type.HudagTorol;
import com.monsource.geotsenoz.data.entity.type.ShugamTorol;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import static com.monsource.geotsenoz.report.excel.EnumConverter.convertHudagTorol;
import static com.monsource.geotsenoz.report.excel.EnumConverter.convertZug;

/**
 * Created by nasanjargal on 6/11/14.
 */
public class ShugamWorkbook extends XSSFWorkbook {
    public ShugamWorkbook() {
        init();
    }

    private void init() {
        for (ShugamTorol shugamTorol : ShugamTorol.values()) {
            Sheet sheet = this.createSheet(shugamTorol.toString());
            int i = 0;
            Row row = sheet.createRow(0);
            row.createCell(i + 0).setCellValue("dugaar");
            row.createCell(i + 1).setCellValue("ehlel_dd");
            row.createCell(i + 2).setCellValue("tugs_dd");
            row.createCell(i + 3).setCellValue("sh_dmtr");
            row.createCell(i + 4).setCellValue("sh_too");
            switch (shugamTorol) {
                case TS:
                    row.createCell(i + 5).setCellValue("tsush_urt");
                    break;
                case DU:
                    row.createCell(i + 5).setCellValue("dush_urt");
                    break;
                case BO:
                    row.createCell(i + 5).setCellValue("bush_urt");
                    break;
            }
            row.createCell(i + 6).setCellValue("sdg_m");
            row.createCell(i + 7).setCellValue("material");
            row.createCell(i + 8).setCellValue("achaalal");
            row.createCell(i + 9).setCellValue("ognoo");
            row.createCell(i + 10).setCellValue("tailbar");
        }
    }

    public void addAll(List<ShugamHooloiEntity> hudags, ShugamTorol torol) {
        Sheet sheet = this.getSheet(torol.toString());

        NumberFormat integerFormat = new DecimalFormat("#");
        NumberFormat doubleFormat = new DecimalFormat("#.00");

        int rowIndex = 1;
        for (ShugamHooloiEntity shugamHooloi : hudags) {

            Row row = sheet.createRow(rowIndex++);
            int i = 0;
            row.createCell(i + 0).setCellValue(shugamHooloi.getDugaar());

            String zugTd = "";
            String zugBo = "";

            if (shugamHooloi.getBarilgaDugaar() != null) {
                if (shugamHooloi.getTorol() == ShugamTorol.BO)
                    zugBo = convertZug(shugamHooloi.getEhZug());
                else
                    zugTd = convertZug(shugamHooloi.getEhZug());
            }

            row.createCell(i + 1).setCellValue(shugamHooloi.getEhHudag().getDugaar() + zugBo);
            row.createCell(i + 2).setCellValue(shugamHooloi.getTugsHudag().getDugaar() + zugTd);

            if (shugamHooloi.getEhHudagShugam().getDiameter() != null)
                row.createCell(i + 3).setCellValue(Integer.valueOf(integerFormat.format(shugamHooloi.getEhHudagShugam().getDiameter())));
            if (shugamHooloi.getEhHudagShugam().getToo() != null)
                row.createCell(i + 4).setCellValue(shugamHooloi.getEhHudagShugam().getToo());

            row.createCell(i + 6).setCellValue(calcSuulgaltGun(shugamHooloi));

            if (shugamHooloi.getMaterial() != null)
                row.createCell(i + 7).setCellValue(shugamHooloi.getMaterial().getName());
            if (shugamHooloi.getAchaalal() != null)
                row.createCell(i + 8).setCellValue(shugamHooloi.getAchaalal());
            if (shugamHooloi.getYear() != null)
                row.createCell(i + 9).setCellValue(shugamHooloi.getYear());
            if (shugamHooloi.getTailbar() != null)
                row.createCell(i + 10).setCellValue(shugamHooloi.getTailbar());
        }
    }

    private double calcSuulgaltGun(ShugamHooloiEntity shugamHooloi) {
        float eGaz = 0;
        float eHo = 0;
        float tGaz = 0;
        float tHo = 0;

        HudagEntity ehHudag = shugamHooloi.getEhHudag();
        HudagEntity tugsHudag = shugamHooloi.getTugsHudag();

        if (ehHudag.getHooloiErool() != null && ehHudag.getHooloiErool() != 0 && ehHudag.getGazTemdegt() != null && ehHudag.getGazTemdegt() != 0) {
            eGaz = ehHudag.getGazTemdegt();
            eHo = ehHudag.getHooloiErool();
        }

        if (tugsHudag.getHooloiErool() != null && tugsHudag.getHooloiErool() != 0 && tugsHudag.getGazTemdegt() != null && tugsHudag.getGazTemdegt() != 0) {
            tGaz = tugsHudag.getGazTemdegt();
            tHo = tugsHudag.getHooloiErool();
        }

        if (eGaz == 0 && eHo == 0) {
            eGaz = tHo;
            eHo = tHo;
        }

        if (tGaz == 0 && tHo == 0) {
            tGaz = eHo;
            tHo = eHo;
        }

        return ((eGaz - eHo) + (tGaz - tHo)) / 2;
    }
}
