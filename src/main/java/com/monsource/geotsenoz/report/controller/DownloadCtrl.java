package com.monsource.geotsenoz.report.controller;

import com.monsource.geotsenoz.data.dao.AimagDao;
import com.monsource.geotsenoz.data.entity.AimagEntity;
import com.monsource.geotsenoz.report.excel.HudagWorkbook;
import com.monsource.geotsenoz.report.excel.ShugamWorkbook;
import com.monsource.geotsenoz.report.service.HudagService;
import com.monsource.geotsenoz.report.service.ShugamService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nasanjargal on 6/11/14.
 */
@Controller
@RequestMapping("/report/download")
public class DownloadCtrl {

    @Autowired
    AimagDao aimagDao;
    @Autowired
    HudagService hudagService;
    @Autowired
    ShugamService shugamService;

    @RequestMapping(value = "hudag.xlsx", method = RequestMethod.GET)
    public void downloadHudag(Integer aimagId, HttpServletResponse response) throws IOException {

        AimagEntity aimag = aimagDao.get(aimagId);

        HudagWorkbook hudagWorkbook = hudagService.getHudagWorkbook(aimag);

        response.setContentType("application/xlsx");
        response.setHeader("Content-Disposition", "attachment; filename=" + aimag.getAimagName() + "_худаг.xlsx");
        hudagWorkbook.write(response.getOutputStream());
        response.getOutputStream().flush();
    }

    @RequestMapping(value = "shugam.xlsx", method = RequestMethod.GET)
    public void downloadShugam(Integer aimagId, HttpServletResponse response) throws IOException {

        AimagEntity aimag = aimagDao.get(aimagId);

        ShugamWorkbook hudagWorkbook = shugamService.getShugamWorkbook(aimag);

        response.setContentType("application/xlsx");
        response.setHeader("Content-Disposition", "attachment; filename=" + aimag.getAimagName() + "_худаг.xlsx");
        hudagWorkbook.write(response.getOutputStream());
        response.getOutputStream().flush();
    }

}
