package com.monsource.geotsenoz.hudag.controller;

import com.monsource.geotsenoz.core.json.JsonData;
import com.monsource.geotsenoz.data.entity.type.HudagTorol;
import com.monsource.geotsenoz.data.entity.type.MaterialZoriulalt;
import com.monsource.geotsenoz.hudag.model.Hudag;
import com.monsource.geotsenoz.hudag.service.HudagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nyamaa on 6/16/14.
 */
@Controller
@RequestMapping("/hudag")
public class HudagController {

    @Autowired
    HudagService hudagSrv;

    //    @RequestMapping("materials.json")
//    @ResponseBody
//    public JsonData getMaterials(MaterialZoriulalt zoriulalt){
//        JsonData data = new JsonData();
//        data.setData(hudagSrv.getMaterials(zoriulalt));
//        return data;
//    }
    @RequestMapping(value = "hudags.json", method = RequestMethod.GET)
    @ResponseBody
    public JsonData findAll(String torol, Integer dugaar) {
        JsonData jsonData = new JsonData();
        jsonData.setData(hudagSrv.findAll(HudagTorol.valueOf(torol), dugaar));
        return jsonData;
    }

    @RequestMapping(value = "hudags.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonData saveAll(@RequestBody List<Hudag> hudags) {
        JsonData jsonData = new JsonData();
        hudagSrv.saveAll(hudags);
        return jsonData;
    }

    @RequestMapping(value = "hudag.json", method = RequestMethod.GET)
    @ResponseBody
    public JsonData findAll(Integer id) {
        JsonData data = new JsonData();
        data.setData(hudagSrv.getModel(id));
        return data;
    }

    /**
     * @param hudag
     */
    @RequestMapping(value = "delete.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonData delete(@RequestBody Hudag hudag) {
        JsonData data = new JsonData();
        hudagSrv.delete(hudag.getHudagId());
        return data;
    }

    @RequestMapping(value = "hudag.json", method = RequestMethod.POST)
    @ResponseBody
    public JsonData save(@RequestBody Hudag hudag) {
        JsonData data = new JsonData();
        hudagSrv.save(hudag);
        return data;
    }
}
