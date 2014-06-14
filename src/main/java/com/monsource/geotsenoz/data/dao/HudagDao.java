package com.monsource.geotsenoz.data.dao;

import com.monsource.geotsenoz.core.data.HibernateDaoSupport;
import com.monsource.geotsenoz.data.entity.AimagEntity;
import com.monsource.geotsenoz.data.entity.HudagEntity;
import com.monsource.geotsenoz.data.entity.type.HudagTorol;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
