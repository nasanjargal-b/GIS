package com.monsource.geotsenoz.hudag.service;

import com.monsource.geotsenoz.aimag.model.AimagSelectedSession;
import com.monsource.geotsenoz.core.json.JsonData;
import com.monsource.geotsenoz.data.dao.AimagDao;
import com.monsource.geotsenoz.data.dao.HudagDao;
import com.monsource.geotsenoz.data.dao.MaterialDao;
import com.monsource.geotsenoz.data.dao.TagDao;
import com.monsource.geotsenoz.data.entity.*;
import com.monsource.geotsenoz.data.entity.type.HudagTorol;
import com.monsource.geotsenoz.data.entity.type.MaterialZoriulalt;
import com.monsource.geotsenoz.data.entity.type.ShugamTorol;
import com.monsource.geotsenoz.data.entity.type.Zug;
import com.monsource.geotsenoz.hudag.model.Hudag;
import com.monsource.geotsenoz.hudag.model.HudagShugam;
import com.monsource.geotsenoz.hudag.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by nyamaa on 6/16/14.
 */
@Service
public class HudagService {

    @Autowired
    HudagDao hudagDao;
    @Autowired
    AimagSelectedSession selectedAimag;
    @Autowired
    AimagDao aimagDao;
    @Autowired
    MaterialDao materialDao;
    @Autowired
    TagDao tagDao;

    public List<Hudag> findAll(HudagTorol torol, Integer dugaar) {
        System.out.println("aimag id: " + selectedAimag.getAimag().getAimagId());
        AimagEntity aimag = aimagDao.get(selectedAimag.getAimag().getAimagId());
        return hudagDao.findAll(aimag, torol, dugaar);
    }

    @Transactional
    public void save(Hudag hudag) {
        HudagEntity entity = new HudagEntity();
        if (hudag.getHudagId() != null) {
            entity.setHudagId(hudag.getHudagId());
        } else {
            entity.setHudagId(null);
        }
        AimagEntity aimagEntity = aimagDao.get(selectedAimag.getAimag().getAimagId());
        entity.setAimag(aimagEntity);
        entity.setDugaar(hudag.getDugaar());
        entity.setGazTemdegt(hudag.getGazTemdegt());
        entity.setGolch(hudag.getGolch());
        entity.setHaalt(hudag.getHaalt());
        entity.setHooloiErool(hudag.getHooloiErool());
        entity.setHudagErool(hudag.getHudagErool());
        Set<HudagShugamEntity> hudagShugams = new HashSet<>();
        if (hudag.getMaterialId() != null && hudag.getMaterialId() != 0) {
            MaterialEntity material = materialDao.get(hudag.getMaterialId());
            entity.setMaterial(material);
        }
        if(hudag.getTagId()!=null && hudag.getTagId()!=0){
            TagEntity tag = tagDao.get(hudag.getTagId());
            entity.setTag(tag);
        }
        entity.setOk(hudag.getOk());
        entity.setOrgon(hudag.getOrgon());
        if (hudag.getTagId() != null) {
            entity.setTag(tagDao.get(hudag.getTagId()));
        }
        entity.setTagTmdgt(hudag.getTagTmdgt());
        entity.setTailbar(hudag.getTailbar());
        entity.setTorol(hudag.getTorol());
        entity.setUrt(hudag.getUrt());
        if (hudag.getHudagShugams() != null) {
            for (HudagShugam hudagShugam : hudag.getHudagShugams()) {
                System.out.println("hudagShugam.getTorol() = " + hudagShugam.getTorol());
                HudagShugamEntity hudagShuEntity = new HudagShugamEntity();
                hudagShuEntity.setDiameter(hudagShugam.getDiameter());
                if(hudagShugam.gethSmaterialId()!=null && hudagShugam.gethSmaterialId()!=0){
                    MaterialEntity material = materialDao.get(hudagShugam.gethSmaterialId());
                    hudagShuEntity.setMaterial(material);
                }
                if(hudagShugam.getHaaltId()!=null && hudagShugam.getHaaltId()!=0){
                    MaterialEntity haalt = materialDao.get(hudagShugam.getHaaltId());
                    hudagShuEntity.setHaalt(haalt);
                }
                hudagShuEntity.setHaaltDiameter(hudagShugam.getHaaltDiameter());
                hudagShuEntity.setHaaltToo(hudagShugam.getHaaltToo());
                hudagShuEntity.setHudag(entity);
                if(hudagShugam.getHudagShugamId()!=0 && hudagShugam.getHudagShugamId()!=null){
                    hudagShuEntity.setHudagShugamId(hudagShugam.getHudagShugamId());
                }else{
                    hudagShuEntity.setHudagShugamId(null);
                }
                hudagShuEntity.setToo(hudagShugam.getToo());
                hudagShuEntity.setTorol(hudagShugam.getTorol());
                hudagShuEntity.setZug(hudagShugam.getZug());
                hudagShugams.add(hudagShuEntity);
            }
            entity.setHudagShugams(hudagShugams);
        }
        entity = hudagDao.merge(entity);
        for (HudagShugamEntity hudagShugamEntity : entity.getHudagShugams()) {
            System.out.println("hudagShugamEntity.getHudagShugamId() = " + hudagShugamEntity.getHudagShugamId());
        }
    }

    @Transactional
    public void delete(Integer id) {
        hudagDao.delete(hudagDao.get(id));
    }

    @Transactional
    public Hudag getModel(Integer id) {
        Hudag model = hudagDao.getModel(id);
        return model;
    }

//    public List<Material> getMaterials(MaterialZoriulalt zoriulalt) {
//        return materialDao.getMaterials(zoriulalt);
//    }

    @Transactional
    public void saveAll(List<Hudag> hudags) {
        for (Hudag hudag : hudags) {
            HudagEntity second = null;
            HudagEntity entity = new HudagEntity();
            if (hudag.getHudagId() != null) {
                entity.setHudagId(hudag.getHudagId());
                second = hudagDao.get(hudag.getHudagId());
            } else {
                entity.setHudagId(null);
            }
            AimagEntity aimagEntity = aimagDao.get(selectedAimag.getAimag().getAimagId());
            entity.setAimag(aimagEntity);
            entity.setDugaar(hudag.getDugaar());
            entity.setGazTemdegt(hudag.getGazTemdegt());
            entity.setGolch(hudag.getGolch());
            entity.setHaalt(hudag.getHaalt());
            entity.setHooloiErool(hudag.getHooloiErool());
            entity.setHudagErool(hudag.getHudagErool());
            entity.setHudagShugams(second.getHudagShugams());
            if (hudag.getMaterialId() != null && hudag.getMaterialId() != 0) {
                MaterialEntity material = materialDao.get(hudag.getMaterialId());
                entity.setMaterial(material);
            }
            if(hudag.getTagId()!=null && hudag.getTagId()!=0){
                TagEntity tag = tagDao.get(hudag.getTagId());
                entity.setTag(tag);
            }
            entity.setOk(hudag.getOk());
            entity.setOrgon(hudag.getOrgon());
            if (hudag.getTagId() != null) {
                entity.setTag(tagDao.get(hudag.getTagId()));
            }
            entity.setTagTmdgt(hudag.getTagTmdgt());
            entity.setTailbar(hudag.getTailbar());
            entity.setTorol(hudag.getTorol());
            entity.setUrt(hudag.getUrt());
            hudagDao.merge(entity);
        }
    }
}
