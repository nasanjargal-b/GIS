package com.monsource.geotsenoz.data.dao;

import com.monsource.geotsenoz.aimag.model.Aimag;
import com.monsource.geotsenoz.core.data.HibernateDaoSupport;
import com.monsource.geotsenoz.data.entity.AimagEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nasanjargal on 6/11/14.
 */
@Repository
public class AimagDao extends HibernateDaoSupport<AimagEntity> {
    public List<Aimag> getAll(String text) {
        Criteria criteria = getSession().createCriteria(AimagEntity.class);
        if (text != null && "".equals(text)) {
            criteria.add(Restrictions.like("aimagName", text, MatchMode.ANYWHERE));
        }
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("aimagId"), "aimagId")
                .add(Projections.property("aimagName"), "aimagName")
        );
        criteria.setResultTransformer(Transformers.aliasToBean(Aimag.class));
        return criteria.list();
    }
}
