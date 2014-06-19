package com.monsource.geotsenoz.data.dao;

import com.monsource.geotsenoz.core.data.HibernateDaoSupport;
import com.monsource.geotsenoz.data.entity.AimagEntity;
import com.monsource.geotsenoz.data.entity.HudagEntity;
import com.monsource.geotsenoz.data.entity.HudagShugamEntity;
import com.monsource.geotsenoz.data.entity.type.HudagTorol;
import com.monsource.geotsenoz.hudag.model.Hudag;
import com.monsource.geotsenoz.hudag.model.HudagShugam;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by nasanjargal on 6/11/14.
 */
@Repository
public class HudagDao extends HibernateDaoSupport<HudagEntity> {
    public List<HudagEntity> find(AimagEntity aimag, HudagTorol torol) {
        Criteria criteria = this.getSession().createCriteria(HudagEntity.class);

        criteria.add(Restrictions.eq("aimag", aimag));
        criteria.add(Restrictions.eq("torol", torol));

        criteria.addOrder(Order.asc("dugaar"));

        return criteria.list();

    }

    public List<Hudag> findAll(AimagEntity aimag, HudagTorol torol, Integer dugaar) {
        Criteria criteria = this.getSession().createCriteria(HudagEntity.class);
        criteria.createAlias("aimag", "aimag", JoinType.LEFT_OUTER_JOIN);
        criteria.createAlias("material", "material", JoinType.LEFT_OUTER_JOIN);
        criteria.createAlias("tag", "tag", JoinType.LEFT_OUTER_JOIN);
        criteria.add(Restrictions.and(
                Restrictions.eq("aimag.aimagId", aimag.getAimagId()),
                Restrictions.eq("torol", torol)
        ));
        if (dugaar != null)
            criteria.add(Restrictions.eq("dugaar", dugaar));
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("urt"), "urt")
                .add(Projections.property("hudagId"), "hudagId")
                .add(Projections.property("dugaar"), "dugaar")
                .add(Projections.property("torol"), "torol")
                .add(Projections.property("orgon"), "orgon")
                .add(Projections.property("hooloiErool"), "hooloiErool")
                .add(Projections.property("hudagErool"), "hudagErool")
                .add(Projections.property("tagTmdgt"), "tagTmdgt")
                .add(Projections.property("golch"), "golch")
                .add(Projections.property("ok"), "ok")
                .add(Projections.property("gazTemdegt"), "gazTemdegt")
                .add(Projections.property("haalt"), "haalt")
                .add(Projections.property("tailbar"), "tailbar")
                .add(Projections.property("aimag.aimagId"), "aimagId")
                .add(Projections.property("material.materialId"), "materialId")
                .add(Projections.property("tag.tagId"), "tagId")
        );
        criteria.addOrder(Order.asc("dugaar"));
        criteria.setResultTransformer(Transformers.aliasToBean(Hudag.class));
        List<Hudag> hudags = criteria.list();
        for (Hudag hudag : hudags) {
            Criteria hudagShugam = this.getSession().createCriteria(HudagShugamEntity.class);
            hudagShugam.createAlias("hudag", "hudag");
            hudagShugam.createAlias("haalt", "haalt");
            hudagShugam.createAlias("material", "material");
            hudagShugam.add(Restrictions.eq("hudag.hudagId", hudag.getHudagId()));
            hudagShugam.setProjection(Projections.projectionList()
                    .add(Projections.property("hudagShugamId"), "hudagShugamId")
                    .add(Projections.property("too"), "too")
                    .add(Projections.property("torol"), "torol")
                    .add(Projections.property("zug"), "zug")
                    .add(Projections.property("diameter"), "diameter")
                    .add(Projections.property("haaltToo"), "haaltToo")
                    .add(Projections.property("haaltDiameter"), "haaltDiameter")
                    .add(Projections.property("haalt.materialId"), "haaltId")
                    .add(Projections.property("material.materialId"), "hSmaterialId")
            );
            hudagShugam.setResultTransformer(Transformers.aliasToBean(HudagShugam.class));
            List<HudagShugam> hudagShugams = hudagShugam.list();
            hudag.setHudagShugams(hudagShugams);
        }
        return hudags;

    }

    public Hudag getModel(Integer id) {
        HudagEntity entity = this.get(id);
        Hudag model = new Hudag();
        model.setUrt(entity.getUrt());
        model.setTailbar(entity.getTailbar());
        model.setGazTemdegt(entity.getGazTemdegt());
        model.setAimagId(entity.getAimag().getAimagId());
        model.setDugaar(entity.getDugaar());
        model.setGolch(entity.getGolch());
        model.setHaalt(entity.getHaalt());
        model.setHooloiErool(entity.getHooloiErool());
        model.setHudagErool(entity.getHudagErool());
        model.setDugaar(entity.getDugaar());
        model.setTagTmdgt(entity.getTagTmdgt());
        model.setHudagId(entity.getHudagId());
        model.setOk(entity.getOk());
        model.setOrgon(entity.getOrgon());
        if (entity.getTag() != null)
            model.setTagId(entity.getTag().getTagId());
        model.setTorol(entity.getTorol());
        if (entity.getMaterial() != null)
            model.setMaterialId(entity.getMaterial().getMaterialId());
        List<HudagShugam> hudagShugams = new ArrayList<>();
        if (entity.getHudagShugams() != null) {
            for (HudagShugamEntity hudagShugamEntity : entity.getHudagShugams()) {
                HudagShugam hudagShugam = new HudagShugam();
                if (hudagShugamEntity.getMaterial() != null && hudagShugamEntity.getMaterial().getMaterialId() != 0)
                    hudagShugam.sethSmaterialId(hudagShugamEntity.getMaterial().getMaterialId());
                hudagShugam.setTorol(hudagShugamEntity.getTorol());
                hudagShugam.setDiameter(hudagShugamEntity.getDiameter());
                hudagShugam.setHaaltDiameter(hudagShugamEntity.getHaaltDiameter());
                if (hudagShugamEntity.getHaalt() != null && hudagShugamEntity.getHaalt().getMaterialId() != 0)
                    hudagShugam.setHaaltId(hudagShugamEntity.getHaalt().getMaterialId());
                hudagShugam.setHaaltToo(hudagShugamEntity.getHaaltToo());
                hudagShugam.setHudagShugamId(hudagShugamEntity.getHudagShugamId());
                hudagShugam.setToo(hudagShugamEntity.getToo());
                hudagShugam.setZug(hudagShugamEntity.getZug());
                hudagShugams.add(hudagShugam);
            }
            model.setHudagShugams(hudagShugams);
        }
        return model;
    }
}
