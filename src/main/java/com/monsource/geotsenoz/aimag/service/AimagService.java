package com.monsource.geotsenoz.aimag.service;

import com.monsource.geotsenoz.aimag.model.Aimag;
import com.monsource.geotsenoz.aimag.model.AimagSelectedSession;
import com.monsource.geotsenoz.data.dao.AimagDao;
import com.monsource.geotsenoz.data.entity.AimagEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nyamaa on 6/15/14.
 */
@Service
public class AimagService {

    @Autowired
    AimagDao aimagDao;

    @Autowired
    AimagSelectedSession aimagSelectedSession;

    public List<Aimag> getAll(String text) {
        return aimagDao.getAll(text);
    }

    public Aimag getModel(Integer id) {
        AimagEntity entity = aimagDao.get(id);
        Aimag aimag = new Aimag();
        aimag.setAimagId(entity.getAimagId());
        aimag.setAimagName(entity.getAimagName());
        return aimag;
    }

    @Transactional
    public void save(Aimag model) {
        AimagEntity aimagEntity = null;
        if (aimagDao.get(model.getAimagId()) != null) {
            aimagEntity = aimagDao.get(model.getAimagId());
        } else {
            aimagEntity = new AimagEntity();
        }
        aimagEntity.setAimagName(model.getAimagName());
        aimagEntity.setAimagId(model.getAimagId());
        aimagDao.merge(aimagEntity);
    }

    @Transactional
    public void delete(Integer id) {
        aimagDao.delete(aimagDao.get(id));
    }

    public void select(Aimag aimag) {
        AimagEntity entity = aimagDao.get(aimag.getAimagId());
        aimag.setAimagName(entity.getAimagName());
        aimag.setAimagId(entity.getAimagId());
        aimagSelectedSession.setAimag(aimag);
    }

    public Aimag check() {
       return aimagSelectedSession.getAimag();
    }
}
