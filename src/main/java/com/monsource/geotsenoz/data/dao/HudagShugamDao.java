package com.monsource.geotsenoz.data.dao;

import com.monsource.geotsenoz.core.data.HibernateDaoSupport;
import com.monsource.geotsenoz.data.entity.HudagShugamEntity;
import com.monsource.geotsenoz.data.entity.MaterialEntity;
import com.monsource.geotsenoz.hudag.model.HudagShugam;
import com.monsource.geotsenoz.hudag.model.Material;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nyamaa on 6/17/14.
 */
@Repository
public class HudagShugamDao extends HibernateDaoSupport<HudagShugamEntity> {

    public List<HudagShugam> find(Integer hudagId) {
        Criteria criteria = this.getSession().createCriteria(HudagShugamEntity.class);
        criteria.createAlias("hudag", "hudag", JoinType.LEFT_OUTER_JOIN);
        criteria.createAlias("haalt", "haalt", JoinType.FULL_JOIN);
        criteria.createAlias("material", "material", JoinType.FULL_JOIN);
        criteria.add(Restrictions.eq("hudag.hudagId", hudagId));
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("hudagShugamId"), "hudagShugamId")
                .add(Projections.property("too"), "too")
                .add(Projections.property("torol"), "torol")
                .add(Projections.property("haaltDiameter"), "haaltDiameter")
                .add(Projections.property("zug"), "zug")
                .add(Projections.property("diameter"), "diameter")
                .add(Projections.property("haaltToo"), "haaltToo")
                .add(Projections.property("haalt.materialId"), "haaltId")
                .add(Projections.property("material.materialId"), "hSmaterialId")
        );
        criteria.setResultTransformer(Transformers.aliasToBean(HudagShugam.class));
        List<HudagShugam> hudagShugams = criteria.list();
        for (HudagShugam hudagShugam : hudagShugams) {
            Criteria haalt = this.getSession().createCriteria(MaterialEntity.class);
            haalt.add(Restrictions.eq("materialId", hudagShugam.getHaaltId()));
            haalt.setProjection(Projections.projectionList()
                    .add(Projections.property("materialId"), "materialId")
                    .add(Projections.property("name"), "name")
                    .add(Projections.property("zoriulalt"), "zoriulalt")
            );
            haalt.setResultTransformer(Transformers.aliasToBean(Material.class));
            Material material = (Material) haalt.uniqueResult();
            if (material != null)
                hudagShugam.setHaaltName(material.getName());
        }
        for (HudagShugam hudagShugam : hudagShugams) {
            Criteria material = this.getSession().createCriteria(MaterialEntity.class);
            material.add(Restrictions.eq("materialId", hudagShugam.gethSmaterialId()));
            material.setProjection(Projections.projectionList()
                    .add(Projections.property("materialId"), "materialId")
                    .add(Projections.property("name"), "name")
                    .add(Projections.property("zoriulalt"), "zoriulalt")
            );
            material.setResultTransformer(Transformers.aliasToBean(Material.class));
            Material material1 = (Material) material.uniqueResult();
            if (material1 != null)
                hudagShugam.sethSmaterialName(material1.getName());
        }
        return hudagShugams;
    }
}
