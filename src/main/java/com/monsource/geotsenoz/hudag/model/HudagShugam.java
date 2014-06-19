package com.monsource.geotsenoz.hudag.model;

import com.monsource.geotsenoz.data.entity.type.ShugamTorol;
import com.monsource.geotsenoz.data.entity.type.Zug;

/**
 * Created by nyamaa on 6/16/14.
 */
public class HudagShugam {
    private Integer hudagShugamId;
    private Integer too;
    private ShugamTorol torol;
    private Zug zug;
    private Float diameter;
    private Integer haaltToo;
    private Float haaltDiameter;
    private Integer haaltId;
    private String haaltName;
    private Integer hSmaterialId;
    private String hSmaterialName;

    public String getHaaltName() {
        return haaltName;
    }

    public void setHaaltName(String haaltName) {
        this.haaltName = haaltName;
    }

    public String gethSmaterialName() {
        return hSmaterialName;
    }

    public void sethSmaterialName(String hSmaterialName) {
        this.hSmaterialName = hSmaterialName;
    }

    public Integer getHudagShugamId() {
        return hudagShugamId;
    }

    public void setHudagShugamId(Integer hudagShugamId) {
        this.hudagShugamId = hudagShugamId;
    }

    public Integer getToo() {
        return too;
    }

    public void setToo(Integer too) {
        this.too = too;
    }

    public ShugamTorol getTorol() {
        return torol;
    }

    public void setTorol(ShugamTorol torol) {
        this.torol = torol;
    }

    public Zug getZug() {
        return zug;
    }

    public void setZug(Zug zug) {
        this.zug = zug;
    }

    public Float getDiameter() {
        return diameter;
    }

    public void setDiameter(Float diameter) {
        this.diameter = diameter;
    }

    public Integer getHaaltToo() {
        return haaltToo;
    }

    public void setHaaltToo(Integer haaltToo) {
        this.haaltToo = haaltToo;
    }

    public Float getHaaltDiameter() {
        return haaltDiameter;
    }

    public void setHaaltDiameter(Float haaltDiameter) {
        this.haaltDiameter = haaltDiameter;
    }

    public Integer getHaaltId() {
        return haaltId;
    }

    public void setHaaltId(Integer haaltId) {
        this.haaltId = haaltId;
    }

    public Integer gethSmaterialId() {
        return hSmaterialId;
    }

    public void sethSmaterialId(Integer hSmaterialId) {
        this.hSmaterialId = hSmaterialId;
    }
}
