package com.monsource.geotsenoz.hudag.controller;

import com.monsource.geotsenoz.core.json.JsonData;
import com.monsource.geotsenoz.data.dao.TagDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nyamaa on 6/18/14.
 */
@Controller
@RequestMapping("/tag")
public class TagController {

    @Autowired
    TagDao tagDao;

    @RequestMapping("tags.json")
    @ResponseBody
    public JsonData getAll(){
        JsonData data = new JsonData();
        data.setData(tagDao.getAll());
        return data;
    }
}
