package com.monsource.geotsenoz.aimag.controller;

import com.monsource.geotsenoz.aimag.model.Aimag;
import com.monsource.geotsenoz.aimag.service.AimagService;
import com.monsource.geotsenoz.core.json.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by nyamaa on 6/15/14.
 */
@Controller
@RequestMapping("/aimag")
public class AimagController {

    @Autowired
    AimagService aimagSrv;

    @RequestMapping("aimags.json")
    @ResponseBody
    public JsonData getAll(String text){
        JsonData data = new JsonData();
        data.setData(aimagSrv.getAll(text));
        return data;
    }

    @RequestMapping(value = "aimag.json",method = RequestMethod.GET)
    @ResponseBody
    public JsonData get(Integer id){
        JsonData data = new JsonData();
        data.setData(aimagSrv.getModel(id));
        return data;
    }

    @RequestMapping(value = "aimag.json",method = RequestMethod.DELETE)
    @ResponseBody
    public JsonData delete(Integer id){
        JsonData data = new JsonData();
        aimagSrv.delete(id);
        return data;
    }

    @RequestMapping(value = "aimag.json",method = RequestMethod.POST)
    @ResponseBody
    public JsonData save(Aimag aimag){
        JsonData data = new JsonData();
        aimagSrv.save(aimag);
        return data;
    }

    @RequestMapping(value = "aimagSelect.json",method = RequestMethod.POST)
    @ResponseBody
    public void select(Aimag aimag){
        aimagSrv.select(aimag);
    }
    @RequestMapping(value = "aimagCheck.json",method = RequestMethod.POST)
    @ResponseBody
    public JsonData check(){
        JsonData jsonData = new JsonData();
        jsonData.setData(aimagSrv.check());
        return jsonData;
    }
}
