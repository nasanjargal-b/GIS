package com.monsource.geotsenoz.hudag.service;

import com.monsource.geotsenoz.data.dao.MaterialDao;
import com.monsource.geotsenoz.data.entity.type.MaterialZoriulalt;
import com.monsource.geotsenoz.hudag.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nyamaa on 6/17/14.
 */
@Service
public class MaterialService {
    @Autowired
    MaterialDao materialDao;

    public List<Material> getAll(MaterialZoriulalt zoriulalt,Integer id){
       return materialDao.getMaterials(zoriulalt,id);
    }
}
