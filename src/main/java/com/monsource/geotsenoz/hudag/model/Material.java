package com.monsource.geotsenoz.hudag.model;

import com.monsource.geotsenoz.data.entity.type.MaterialZoriulalt;

/**
 * Created by nyamaa on 6/17/14.
 */
public class Material {
    private Integer materialId;
    private String name;
    private MaterialZoriulalt zoriulalt;

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MaterialZoriulalt getZoriulalt() {
        return zoriulalt;
    }

    public void setZoriulalt(MaterialZoriulalt zoriulalt) {
        this.zoriulalt = zoriulalt;
    }
}
