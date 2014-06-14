package com.monsource.geotsenoz.report.excel;

import com.monsource.geotsenoz.data.entity.HudagEntity;
import com.monsource.geotsenoz.data.entity.HudagShugamEntity;
import com.monsource.geotsenoz.data.entity.type.HudagTorol;
import com.monsource.geotsenoz.data.entity.type.ShugamTorol;
import com.monsource.geotsenoz.data.entity.type.Zug;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static com.monsource.geotsenoz.report.excel.EnumConverter.*;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nasanjargal on 6/11/14.
 */
public class HudagWorkbook extends XSSFWorkbook {
    public HudagWorkbook() {
        init();
    }

    private void init() {
        for (HudagTorol hudagTorol : HudagTorol.values()) {
            Sheet sheet = this.createSheet(hudagTorol.toString());
            int i = 0;
            Row row = sheet.createRow(0);
            row.createCell(i++).setCellValue("dugaar");
            row.createCell(i++).setCellValue("torol");
            row.createCell(i++).setCellValue("hemjee_mm");
            row.createCell(i++).setCellValue("material");
            row.createCell(i++).setCellValue("tag_tmdgt");
            row.createCell(i++).setCellValue("gaz_tmdgt");
            row.createCell(i++).setCellValue("hooloi_erl");
            row.createCell(i++).setCellValue("hudag_erl");
            row.createCell(i++).setCellValue("baruun");
            row.createCell(i++).setCellValue("baruunhoid");
            row.createCell(i++).setCellValue("baruunurd");
            row.createCell(i++).setCellValue("zuun");
            row.createCell(i++).setCellValue("zuun_hoid");
            row.createCell(i++).setCellValue("zuun_urd");
            row.createCell(i++).setCellValue("urd");
            row.createCell(i++).setCellValue("hoid");
            row.createCell(i++).setCellValue("tailbar");
        }
    }

    public void addAll(List<HudagEntity> hudags, HudagTorol torol) {
        Sheet sheet = this.getSheet(torol.toString());

        NumberFormat numberFormat = new DecimalFormat("#");
        NumberFormat doubleFormat = new DecimalFormat("#.00");

        int rowIndex = 1;
        for (HudagEntity hudag : hudags) {
            Row row = sheet.createRow(rowIndex++);
            int i = 0;
            row.createCell(i + 0).setCellValue(hudag.getDugaar());
            row.createCell(i + 1).setCellValue(convertHudagTorol(hudag.getTorol()));

            if (hudag.getGolch() != null && !hudag.getGolch().equals(""))
                row.createCell(i + 2).setCellValue(hudag.getGolch());
            else if (hudag.getOrgon() != null && hudag.getUrt() != null)
                row.createCell(i + 2).setCellValue(numberFormat.format(hudag.getOrgon()) + "x" + numberFormat.format(hudag.getUrt()));

            if (hudag.getMaterial() != null)
                row.createCell(i + 3).setCellValue(hudag.getMaterial().getName());
            if (hudag.getTagTmdgt() != null)
                row.createCell(i + 4).setCellValue(Double.valueOf(doubleFormat.format(hudag.getTagTmdgt())));
            if (hudag.getGazTemdegt() != null)
                row.createCell(i + 5).setCellValue(Double.valueOf(doubleFormat.format(hudag.getGazTemdegt())));
            if (hudag.getHooloiErool() != null)
                row.createCell(i + 6).setCellValue(Double.valueOf(doubleFormat.format(hudag.getHooloiErool())));
            if (hudag.getHudagErool() != null)
                row.createCell(i + 7).setCellValue(Double.valueOf(doubleFormat.format(hudag.getHudagErool())));

            row.createCell(i + 8).setCellValue(getShugam(hudag, Zug.B));
            row.createCell(i + 9).setCellValue(getShugam(hudag, Zug.BH));
            row.createCell(i + 10).setCellValue(getShugam(hudag, Zug.BU));
            row.createCell(i + 11).setCellValue(getShugam(hudag, Zug.Z));
            row.createCell(i + 12).setCellValue(getShugam(hudag, Zug.ZH));
            row.createCell(i + 13).setCellValue(getShugam(hudag, Zug.ZU));
            row.createCell(i + 14).setCellValue(getShugam(hudag, Zug.U));
            row.createCell(i + 15).setCellValue(getShugam(hudag, Zug.H));
            row.createCell(i + 16).setCellValue(hudag.getTailbar());

        }
    }

    private String getShugam(HudagEntity hudag, Zug zug) {

        Map<ShugamTorol, List<String>> data = new HashMap<>();
        NumberFormat numberFormat = new DecimalFormat("#");

        for (ShugamTorol shugamTorol : ShugamTorol.values()) {
            data.put(shugamTorol, new ArrayList<String>());
        }

        for (HudagShugamEntity hudagShugam : hudag.getHudagShugams()) {
            String torol = "";
            switch (hudagShugam.getTorol()) {
                case DU:
                    torol = "д-";
                    break;
                case TS:
                    torol = "ц-";
                    break;
            }

            if (hudagShugam.getZug() == zug) {
                StringBuilder builder = new StringBuilder(torol);

                builder.append(numberFormat.format(hudagShugam.getDiameter()) + "x" + hudagShugam.getToo() + " ");
                builder.append(hudagShugam.getMaterial() != null ? hudagShugam.getMaterial().getName() + "" : "");

                if (hudagShugam.getHaaltDiameter() != null && hudagShugam.getHaaltDiameter() != 0) {
                    builder.append(" " + numberFormat.format(hudagShugam.getHaaltDiameter()) + "x" + hudagShugam.getHaaltToo() + " ");
                    builder.append(hudagShugam.getHaalt() != null ? hudagShugam.getHaalt().getName() : "");
                }

                data.get(hudagShugam.getTorol()).add(builder.toString());
            }
        }

        List<String> values = new ArrayList<>();

        if (data.get(ShugamTorol.TS).size() > 0)
            values.add(StringUtils.join(data.get(ShugamTorol.TS), ", "));
        if (data.get(ShugamTorol.DU).size() > 0)
            values.add(StringUtils.join(data.get(ShugamTorol.DU), ", "));
        if (data.get(ShugamTorol.BO).size() > 0)
            values.add(StringUtils.join(data.get(ShugamTorol.BO), ", "));

        return StringUtils.join(values, ", ");
    }
}
