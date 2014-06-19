package com.monsource.geotsenoz.hudag.controller;

import com.monsource.geotsenoz.core.json.JsonData;
import com.monsource.geotsenoz.data.entity.type.MaterialZoriulalt;
import com.monsource.geotsenoz.hudag.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nyamaa on 6/17/14.
 */
@Controller
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    MaterialService materialSrv;

    @RequestMapping(value = "materials.json",method = RequestMethod.GET)
    @ResponseBody
    public JsonData getAll(MaterialZoriulalt zoriulalt,Integer id){
        JsonData data = new JsonData();
        data.setData(materialSrv.getAll(zoriulalt,id));
        return data;
    }
}
