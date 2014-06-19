package com.monsource.geotsenoz.data.dao;

import com.monsource.geotsenoz.core.data.HibernateDaoSupport;
import com.monsource.geotsenoz.data.entity.MaterialEntity;
import com.monsource.geotsenoz.data.entity.type.MaterialZoriulalt;
import com.monsource.geotsenoz.hudag.model.Material;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nyamaa on 6/16/14.
 */
@Repository
public class MaterialDao extends HibernateDaoSupport<MaterialEntity> {

    public List<Material> getMaterials(MaterialZoriulalt zoriulalt,Integer id) {
        Criteria criteria = this.getSession().createCriteria(MaterialEntity.class);
        criteria.add(Restrictions.eq("zoriulalt", zoriulalt));
        if(id!=null && id!=0){
            criteria.add(Restrictions.eq("materialId",id));
        }
        criteria.setProjection(Projections.projectionList()
            .add(Projections.property("materialId"),"materialId")
            .add(Projections.property("name"),"name")
            .add(Projections.property("zoriulalt"),"zoriulalt")
        );
        criteria.setResultTransformer(Transformers.aliasToBean(Material.class));
        return criteria.list();
    }
}
