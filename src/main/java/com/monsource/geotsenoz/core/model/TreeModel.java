package com.monsource.geotsenoz.core.model;

import java.util.List;

/**
 * Created by nasanjargal on 5/31/14.
 */
public interface TreeModel<K>  {

    public K getId();

    public String getName();

    public boolean isLeaf();

    public List getChildren();

}
