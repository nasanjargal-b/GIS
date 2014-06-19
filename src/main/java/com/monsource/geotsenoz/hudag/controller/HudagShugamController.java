package com.monsource.geotsenoz.hudag.controller;

import com.monsource.geotsenoz.core.json.JsonData;
import com.monsource.geotsenoz.hudag.service.HudagShugamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nyamaa on 6/17/14.
 */
@Controller
@RequestMapping("/hudagshugam")
public class HudagShugamController {
    @Autowired
    HudagShugamService hudagShugamSrv;

    @RequestMapping("find.json")
    @ResponseBody
    public JsonData find(Integer hudagId){
        JsonData data = new JsonData();
        data.setData(hudagShugamSrv.find(hudagId));
        return data;
    }
}
