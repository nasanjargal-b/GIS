package com.monsource.geotsenoz.data.entity;

import com.monsource.geotsenoz.core.data.DataEntity;
import com.monsource.geotsenoz.data.entity.type.HudagTorol;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by nasanjargal on 6/11/14.
 */
@Entity
@Table(name = "hudag", schema = "public", catalog = "geo")
public class HudagEntity implements DataEntity {
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
    private AimagEntity aimag;
    private MaterialEntity material;
    private TagEntity tag;
    private Set<HudagShugamEntity> hudagShugams;
    private Set<ShugamHooloiEntity> tugsShugamHoolois;
    private Set<ShugamHooloiEntity> ehShugamHoolois;

    @Id
    @Column(name = "hudag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getHudagId() {
        return hudagId;
    }

    public void setHudagId(Integer hudagId) {
        this.hudagId = hudagId;
    }

    @Basic
    @Column(name = "dugaar")
    public Integer getDugaar() {
        return dugaar;
    }

    public void setDugaar(Integer dugaar) {
        this.dugaar = dugaar;
    }

    @Basic
    @Column(name = "torol")
    @Enumerated(EnumType.STRING)
    public HudagTorol getTorol() {
        return torol;
    }

    public void setTorol(HudagTorol torol) {
        this.torol = torol;
    }

    @Basic
    @Column(name = "orgon")
    public Float getOrgon() {
        return orgon;
    }

    public void setOrgon(Float orgon) {
        this.orgon = orgon;
    }

    @Basic
    @Column(name = "urt")
    public Float getUrt() {
        return urt;
    }

    public void setUrt(Float urt) {
        this.urt = urt;
    }

    @Basic
    @Column(name = "hooloi_erool")
    public Float getHooloiErool() {
        return hooloiErool;
    }

    public void setHooloiErool(Float hooloiErool) {
        this.hooloiErool = hooloiErool;
    }

    @Basic
    @Column(name = "hudag_erool")
    public Float getHudagErool() {
        return hudagErool;
    }

    public void setHudagErool(Float hudagErool) {
        this.hudagErool = hudagErool;
    }

    @Basic
    @Column(name = "tag_tmdgt")
    public Float getTagTmdgt() {
        return tagTmdgt;
    }

    public void setTagTmdgt(Float tagTmdgt) {
        this.tagTmdgt = tagTmdgt;
    }

    @Basic
    @Column(name = "golch")
    public String getGolch() {
        return golch;
    }

    public void setGolch(String golch) {
        this.golch = golch;
    }

    @Basic
    @Column(name = "ok")
    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    @Basic
    @Column(name = "gaz_temdegt")
    public Float getGazTemdegt() {
        return gazTemdegt;
    }

    public void setGazTemdegt(Float gazTemdegt) {
        this.gazTemdegt = gazTemdegt;
    }

    @Basic
    @Column(name = "haalt")
    public Float getHaalt() {
        return haalt;
    }

    public void setHaalt(Float haalt) {
        this.haalt = haalt;
    }

    @Basic
    @Column(name = "tailbar")
    public String getTailbar() {
        return tailbar;
    }

    public void setTailbar(String tailbar) {
        this.tailbar = tailbar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HudagEntity that = (HudagEntity) o;

        if (dugaar != null ? !dugaar.equals(that.dugaar) : that.dugaar != null) return false;
        if (gazTemdegt != null ? !gazTemdegt.equals(that.gazTemdegt) : that.gazTemdegt != null) return false;
        if (golch != null ? !golch.equals(that.golch) : that.golch != null) return false;
        if (haalt != null ? !haalt.equals(that.haalt) : that.haalt != null) return false;
        if (hooloiErool != null ? !hooloiErool.equals(that.hooloiErool) : that.hooloiErool != null) return false;
        if (hudagErool != null ? !hudagErool.equals(that.hudagErool) : that.hudagErool != null) return false;
        if (hudagId != null ? !hudagId.equals(that.hudagId) : that.hudagId != null) return false;
        if (ok != null ? !ok.equals(that.ok) : that.ok != null) return false;
        if (orgon != null ? !orgon.equals(that.orgon) : that.orgon != null) return false;
        if (tagTmdgt != null ? !tagTmdgt.equals(that.tagTmdgt) : that.tagTmdgt != null) return false;
        if (tailbar != null ? !tailbar.equals(that.tailbar) : that.tailbar != null) return false;
        if (torol != null ? !torol.equals(that.torol) : that.torol != null) return false;
        if (urt != null ? !urt.equals(that.urt) : that.urt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = hudagId != null ? hudagId.hashCode() : 0;
        result = 31 * result + (dugaar != null ? dugaar.hashCode() : 0);
        result = 31 * result + (torol != null ? torol.hashCode() : 0);
        result = 31 * result + (orgon != null ? orgon.hashCode() : 0);
        result = 31 * result + (urt != null ? urt.hashCode() : 0);
        result = 31 * result + (hooloiErool != null ? hooloiErool.hashCode() : 0);
        result = 31 * result + (hudagErool != null ? hudagErool.hashCode() : 0);
        result = 31 * result + (tagTmdgt != null ? tagTmdgt.hashCode() : 0);
        result = 31 * result + (golch != null ? golch.hashCode() : 0);
        result = 31 * result + (ok != null ? ok.hashCode() : 0);
        result = 31 * result + (gazTemdegt != null ? gazTemdegt.hashCode() : 0);
        result = 31 * result + (haalt != null ? haalt.hashCode() : 0);
        result = 31 * result + (tailbar != null ? tailbar.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "aimag_id", referencedColumnName = "aimag_id", nullable = false)
    public AimagEntity getAimag() {
        return aimag;
    }

    public void setAimag(AimagEntity aimag) {
        this.aimag = aimag;
    }

    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "material_id")
    public MaterialEntity getMaterial() {
        return material;
    }

    public void setMaterial(MaterialEntity material) {
        this.material = material;
    }

    @ManyToOne
    @JoinColumn(name = "tag_id", referencedColumnName = "tag_id")
    public TagEntity getTag() {
        return tag;
    }

    public void setTag(TagEntity tag) {
        this.tag = tag;
    }

    @OneToMany(mappedBy = "hudag",orphanRemoval = true,cascade = CascadeType.ALL)
    public Set<HudagShugamEntity> getHudagShugams() {
        return hudagShugams;
    }

    public void setHudagShugams(Set<HudagShugamEntity> hudagShugams) {
        this.hudagShugams = hudagShugams;
    }

    @OneToMany(mappedBy = "tugsHudag")
    public Set<ShugamHooloiEntity> getTugsShugamHoolois() {
        return tugsShugamHoolois;
    }

    public void setTugsShugamHoolois(Set<ShugamHooloiEntity> tugsShugamHoolois) {
        this.tugsShugamHoolois = tugsShugamHoolois;
    }

    @OneToMany(mappedBy = "ehHudag")
    public Set<ShugamHooloiEntity> getEhShugamHoolois() {
        return ehShugamHoolois;
    }

    public void setEhShugamHoolois(Set<ShugamHooloiEntity> ehShugamHoolois) {
        this.ehShugamHoolois = ehShugamHoolois;
    }
}
