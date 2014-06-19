package com.monsource.geotsenoz.hudag.service;

import com.monsource.geotsenoz.data.dao.HudagShugamDao;
import com.monsource.geotsenoz.hudag.model.HudagShugam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nyamaa on 6/17/14.
 */
@Service
public class HudagShugamService {
    @Autowired
    HudagShugamDao hudagShugamDao;

    public List<HudagShugam> find(Integer hudagId){
        return hudagShugamDao.find(hudagId);
    }
}
