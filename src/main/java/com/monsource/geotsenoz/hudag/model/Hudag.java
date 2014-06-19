package com.monsource.geotsenoz.hudag.model;

import com.monsource.geotsenoz.aimag.model.Aimag;
import com.monsource.geotsenoz.data.entity.type.HudagTorol;

import java.util.List;
import java.util.Set;

/**
 * Created by nyamaa on 6/16/14.
 */
public class Hudag {
    private Integer hudagId;
    private Integer dugaar;
    private HudagTorol torol;
    private Float orgon;
    private Float urt;
    private Float hooloiErool;
    private Float hudagErool;
    private Float tagTmdgt;
    private String golch;
    private Boolean ok;
    private Float gazTemdegt;
    private Float haalt;
    private String tailbar;
    private Integer aimagId;
    private Integer materialId;
    private Integer tagId;
    private List<HudagShugam> hudagShugams;

    public Integer getAimagId() {
        return aimagId;
    }

    public void setAimagId(Integer aimagId) {
        this.aimagId = aimagId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getHudagId() {
        return hudagId;
    }

    public void setHudagId(Integer hudagId) {
        this.hudagId = hudagId;
    }

    public Integer getDugaar() {
        return dugaar;
    }

    public void setDugaar(Integer dugaar) {
        this.dugaar = dugaar;
    }

    public HudagTorol getTorol() {
        return torol;
    }

    public void setTorol(HudagTorol torol) {
        this.torol = torol;
    }

    public Float getOrgon() {
        return orgon;
    }

    public void setOrgon(Float orgon) {
        this.orgon = orgon;
    }

    public Float getUrt() {
        return urt;
    }

    public void setUrt(Float urt) {
        this.urt = urt;
    }

    public Float getHooloiErool() {
        return hooloiErool;
    }

    public void setHooloiErool(Float hooloiErool) {
        this.hooloiErool = hooloiErool;
    }

    public Float getHudagErool() {
        return hudagErool;
    }

    public void setHudagErool(Float hudagErool) {
        this.hudagErool = hudagErool;
    }

    public Float getTagTmdgt() {
        return tagTmdgt;
    }

    public void setTagTmdgt(Float tagTmdgt) {
        this.tagTmdgt = tagTmdgt;
    }

    public String getGolch() {
        return golch;
    }

    public void setGolch(String golch) {
        this.golch = golch;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public Float getGazTemdegt() {
        return gazTemdegt;
    }

    public void setGazTemdegt(Float gazTemdegt) {
        this.gazTemdegt = gazTemdegt;
    }

    public Float getHaalt() {
        return haalt;
    }

    public void setHaalt(Float haalt) {
        this.haalt = haalt;
    }

    public String getTailbar() {
        return tailbar;
    }

    public void setTailbar(String tailbar) {
        this.tailbar = tailbar;
    }

    public List<HudagShugam> getHudagShugams() {
        return hudagShugams;
    }

    public void setHudagShugams(List<HudagShugam> hudagShugams) {
        this.hudagShugams = hudagShugams;
    }
}
