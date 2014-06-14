package com.monsource.geotsenoz.data.dao;

import com.monsource.geotsenoz.core.data.HibernateDaoSupport;
import com.monsource.geotsenoz.data.entity.AimagEntity;
import com.monsource.geotsenoz.data.entity.ShugamHooloiEntity;
import com.monsource.geotsenoz.data.entity.type.ShugamTorol;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nasanjargal on 6/11/14.
 */
@Repository
public class ShugamHooloiDao extends HibernateDaoSupport<ShugamHooloiEntity> {
    public List<ShugamHooloiEntity> find(AimagEntity aimag, ShugamTorol torol) {
        Criteria criteria = this.getSession().createCriteria(ShugamHooloiEntity.class);

        criteria.add(Restrictions.eq("aimag", aimag));
        criteria.add(Restrictions.eq("torol", torol));

        criteria.addOrder(Order.asc("dugaar"));

        return criteria.list();

    }
}
