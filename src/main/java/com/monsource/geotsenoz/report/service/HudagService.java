package com.monsource.geotsenoz.report.service;

import com.monsource.geotsenoz.data.dao.HudagDao;
import com.monsource.geotsenoz.data.entity.AimagEntity;
import com.monsource.geotsenoz.data.entity.HudagEntity;
import com.monsource.geotsenoz.data.entity.type.HudagTorol;
import com.monsource.geotsenoz.report.excel.HudagWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nasanjargal on 6/11/14.
 */
@Service
public class HudagService {
    @Autowired
    HudagDao hudagDao;

    public HudagWorkbook getHudagWorkbook(AimagEntity aimag) {
        HudagWorkbook workbook = new HudagWorkbook();

        for (HudagTorol torol : HudagTorol.values()) {
            List<HudagEntity> hudags = hudagDao.find(aimag, torol);

            workbook.addAll(hudags, torol);

        }

        return workbook;
    }
}
