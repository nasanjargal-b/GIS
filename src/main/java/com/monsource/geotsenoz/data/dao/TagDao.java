package com.monsource.geotsenoz.data.dao;

import com.monsource.geotsenoz.core.data.HibernateDaoSupport;
import com.monsource.geotsenoz.data.entity.TagEntity;
import com.monsource.geotsenoz.hudag.model.Tag;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nyamaa on 6/16/14.
 */
@Repository
public class TagDao extends HibernateDaoSupport<TagEntity> {
    public List<Tag> getAll(){
        Criteria criteria = this.getSession().createCriteria(TagEntity.class);
        criteria.setProjection(Projections.projectionList()
            .add(Projections.property("tagId"),"tagId")
            .add(Projections.property("name"),"name")
        );
        criteria.setResultTransformer(Transformers.aliasToBean(Tag.class));
        return criteria.list();
    }
}
