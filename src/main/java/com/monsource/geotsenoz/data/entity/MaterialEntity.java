package com.monsource.geotsenoz.data.entity;

import com.monsource.geotsenoz.core.data.DataEntity;
import com.monsource.geotsenoz.data.entity.type.MaterialZoriulalt;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by nasanjargal on 6/11/14.
 */
@Entity
@Table(name = "material", schema = "public", catalog = "geo")
public class MaterialEntity implements DataEntity {
    private Integer materialId;
    private String name;
    private MaterialZoriulalt zoriulalt;
    private Set<HudagEntity> hudags;
    private Set<HudagShugamEntity> haaltHudagShugams;
    private Set<HudagShugamEntity> hudagShugams;
    private Set<ShugamHooloiEntity> shugamHoolois;

    @Id
    @Column(name = "material_id")
    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "zoriulalt")
    @Enumerated(EnumType.STRING)
    public MaterialZoriulalt getZoriulalt() {
        return zoriulalt;
    }

    public void setZoriulalt(MaterialZoriulalt zoriulalt) {
        this.zoriulalt = zoriulalt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaterialEntity that = (MaterialEntity) o;

        if (materialId != null ? !materialId.equals(that.materialId) : that.materialId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (zoriulalt != null ? !zoriulalt.equals(that.zoriulalt) : that.zoriulalt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = materialId != null ? materialId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (zoriulalt != null ? zoriulalt.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "material")
    public Set<HudagEntity> getHudags() {
        return hudags;
    }

    public void setHudags(Set<HudagEntity> hudags) {
        this.hudags = hudags;
    }

    @OneToMany(mappedBy = "haalt")
    public Set<HudagShugamEntity> getHaaltHudagShugams() {
        return haaltHudagShugams;
    }

    public void setHaaltHudagShugams(Set<HudagShugamEntity> haaltHudagShugams) {
        this.haaltHudagShugams = haaltHudagShugams;
    }

    @OneToMany(mappedBy = "material")
    public Set<HudagShugamEntity> getHudagShugams() {
        return hudagShugams;
    }

    public void setHudagShugams(Set<HudagShugamEntity> hudagShugams) {
        this.hudagShugams = hudagShugams;
    }

    @OneToMany(mappedBy = "material")
    public Set<ShugamHooloiEntity> getShugamHoolois() {
        return shugamHoolois;
    }

    public void setShugamHoolois(Set<ShugamHooloiEntity> shugamHoolois) {
        this.shugamHoolois = shugamHoolois;
    }
}
