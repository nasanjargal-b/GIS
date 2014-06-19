package com.monsource.geotsenoz.data.entity;

import com.monsource.geotsenoz.core.data.DataEntity;
import com.monsource.geotsenoz.data.entity.type.ShugamTorol;
import com.monsource.geotsenoz.data.entity.type.Zug;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by nasanjargal on 6/11/14.
 */
@Entity
@Table(name = "hudag_shugam", schema = "public", catalog = "geo")
public class HudagShugamEntity implements DataEntity {
    private Integer hudagShugamId;
    private Integer too;
    private ShugamTorol torol;
    private Zug zug;
    private Float diameter;
    private Integer haaltToo;
    private Float haaltDiameter;
    private HudagEntity hudag;
    private MaterialEntity haalt;
    private MaterialEntity material;
    private Set<ShugamHooloiEntity> ehShugamHoolois;
    private Set<ShugamHooloiEntity> tugsShugamHoolois;

    @Id
    @Column(name = "hudag_shugam_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getHudagShugamId() {
        return hudagShugamId;
    }

    public void setHudagShugamId(Integer hudagShugamId) {
        this.hudagShugamId = hudagShugamId;
    }

    @Basic
    @Column(name = "too")
    public Integer getToo() {
        return too;
    }

    public void setToo(Integer too) {
        this.too = too;
    }

    @Basic
    @Column(name = "torol")
    @Enumerated(EnumType.STRING)
    public ShugamTorol getTorol() {
        return torol;
    }

    public void setTorol(ShugamTorol torol) {
        this.torol = torol;
    }

    @Basic
    @Column(name = "zug")
    @Enumerated(EnumType.STRING)
    public Zug getZug() {
        return zug;
    }

    public void setZug(Zug zug) {
        this.zug = zug;
    }

    @Basic
    @Column(name = "diameter")
    public Float getDiameter() {
        return diameter;
    }

    public void setDiameter(Float diameter) {
        this.diameter = diameter;
    }

    @Basic
    @Column(name = "haalt_too")
    public Integer getHaaltToo() {
        return haaltToo;
    }

    public void setHaaltToo(Integer haaltToo) {
        this.haaltToo = haaltToo;
    }

    @Basic
    @Column(name = "haalt_diameter")
    public Float getHaaltDiameter() {
        return haaltDiameter;
    }

    public void setHaaltDiameter(Float haaltDiameter) {
        this.haaltDiameter = haaltDiameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HudagShugamEntity that = (HudagShugamEntity) o;

        if (diameter != null ? !diameter.equals(that.diameter) : that.diameter != null) return false;
        if (haaltDiameter != null ? !haaltDiameter.equals(that.haaltDiameter) : that.haaltDiameter != null)
            return false;
        if (haaltToo != null ? !haaltToo.equals(that.haaltToo) : that.haaltToo != null) return false;
        if (hudagShugamId != null ? !hudagShugamId.equals(that.hudagShugamId) : that.hudagShugamId != null)
            return false;
        if (too != null ? !too.equals(that.too) : that.too != null) return false;
        if (torol != null ? !torol.equals(that.torol) : that.torol != null) return false;
        if (zug != null ? !zug.equals(that.zug) : that.zug != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hudagShugamId != null ? hudagShugamId.hashCode() : 0;
        result = 31 * result + (too != null ? too.hashCode() : 0);
        result = 31 * result + (torol != null ? torol.hashCode() : 0);
        result = 31 * result + (zug != null ? zug.hashCode() : 0);
        result = 31 * result + (diameter != null ? diameter.hashCode() : 0);
        result = 31 * result + (haaltToo != null ? haaltToo.hashCode() : 0);
        result = 31 * result + (haaltDiameter != null ? haaltDiameter.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "hudag_id", referencedColumnName = "hudag_id", nullable = false)
    public HudagEntity getHudag() {
        return hudag;
    }

    public void setHudag(HudagEntity hudag) {
        this.hudag = hudag;
    }

    @ManyToOne
    @JoinColumn(name = "haalt", referencedColumnName = "material_id")
    public MaterialEntity getHaalt() {
        return haalt;
    }

    public void setHaalt(MaterialEntity haalt) {
        this.haalt = haalt;
    }

    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "material_id")
    public MaterialEntity getMaterial() {
        return material;
    }

    public void setMaterial(MaterialEntity material) {
        this.material = material;
    }

    @OneToMany(mappedBy = "ehHudagShugam")
    public Set<ShugamHooloiEntity> getEhShugamHoolois() {
        return ehShugamHoolois;
    }

    public void setEhShugamHoolois(Set<ShugamHooloiEntity> ehShugamHoolois) {
        this.ehShugamHoolois = ehShugamHoolois;
    }

    @OneToMany(mappedBy = "tugsHudagShugam")
    public Set<ShugamHooloiEntity> getTugsShugamHoolois() {
        return tugsShugamHoolois;
    }

    public void setTugsShugamHoolois(Set<ShugamHooloiEntity> tugsShugamHoolois) {
        this.tugsShugamHoolois = tugsShugamHoolois;
    }
}
