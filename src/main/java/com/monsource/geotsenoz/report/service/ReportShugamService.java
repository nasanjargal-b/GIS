package com.monsource.geotsenoz.report.service;

import com.monsource.geotsenoz.data.dao.ShugamHooloiDao;
import com.monsource.geotsenoz.data.entity.AimagEntity;
import com.monsource.geotsenoz.data.entity.ShugamHooloiEntity;
import com.monsource.geotsenoz.data.entity.type.ShugamTorol;
import com.monsource.geotsenoz.report.excel.ShugamWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nasanjargal on 6/11/14.
 */
@Service
public class ReportShugamService {
    @Autowired
    ShugamHooloiDao shugamHooloiDao;

    public ShugamWorkbook getShugamWorkbook(AimagEntity aimag) {
        ShugamWorkbook workbook = new ShugamWorkbook();

        for (ShugamTorol torol : ShugamTorol.values()) {
            List<ShugamHooloiEntity> hudags = shugamHooloiDao.find(aimag, torol);

            workbook.addAll(hudags, torol);

        }

        return workbook;
    }
}
