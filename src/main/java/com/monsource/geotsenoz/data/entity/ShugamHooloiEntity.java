package com.monsource.geotsenoz.data.entity;

import com.monsource.geotsenoz.core.data.DataEntity;
import com.monsource.geotsenoz.data.entity.type.ShugamTorol;
import com.monsource.geotsenoz.data.entity.type.Zug;

import javax.persistence.*;

/**
 * Created by nasanjargal on 6/11/14.
 */
@Entity
@Table(name = "shugam_hooloi", schema = "public", catalog = "geo")
public class ShugamHooloiEntity implements DataEntity {
    private Integer shugamHooloiId;
    private Integer dugaar;
    private Zug ehZug;
    private Zug tugsZug;
    private Float diameter;
    private Float suulgaltGun;
    private String achaalal;
    private String tailbar;
    private ShugamTorol torol;
    private Integer barilgaDugaar;
    private Integer year;
    private AimagEntity aimag;
    private HudagEntity tugsHudag;
    private HudagEntity ehHudag;
    private HudagShugamEntity ehHudagShugam;
    private HudagShugamEntity tugsHudagShugam;
    private MaterialEntity material;

    @Id
    @Column(name = "shugam_hooloi_id")
    public Integer getShugamHooloiId() {
        return shugamHooloiId;
    }

    public void setShugamHooloiId(Integer shugamHooloiId) {
        this.shugamHooloiId = shugamHooloiId;
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
    @Column(name = "eh_zug")
    @Enumerated(EnumType.STRING)
    public Zug getEhZug() {
        return ehZug;
    }

    public void setEhZug(Zug ehZug) {
        this.ehZug = ehZug;
    }

    @Basic
    @Column(name = "tugs_zug")
    @Enumerated(EnumType.STRING)
    public Zug getTugsZug() {
        return tugsZug;
    }

    public void setTugsZug(Zug tugsZug) {
        this.tugsZug = tugsZug;
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
    @Column(name = "suulgalt_gun")
    public Float getSuulgaltGun() {
        return suulgaltGun;
    }

    public void setSuulgaltGun(Float suulgaltGun) {
        this.suulgaltGun = suulgaltGun;
    }

    @Basic
    @Column(name = "achaalal")
    public String getAchaalal() {
        return achaalal;
    }

    public void setAchaalal(String achaalal) {
        this.achaalal = achaalal;
    }

    @Basic
    @Column(name = "tailbar")
    public String getTailbar() {
        return tailbar;
    }

    public void setTailbar(String tailbar) {
        this.tailbar = tailbar;
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
    @Column(name = "barilga_dugaar")
    public Integer getBarilgaDugaar() {
        return barilgaDugaar;
    }

    public void setBarilgaDugaar(Integer barilgaDugaar) {
        this.barilgaDugaar = barilgaDugaar;
    }

    @Basic
    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShugamHooloiEntity that = (ShugamHooloiEntity) o;

        if (achaalal != null ? !achaalal.equals(that.achaalal) : that.achaalal != null) return false;
        if (barilgaDugaar != null ? !barilgaDugaar.equals(that.barilgaDugaar) : that.barilgaDugaar != null)
            return false;
        if (diameter != null ? !diameter.equals(that.diameter) : that.diameter != null) return false;
        if (dugaar != null ? !dugaar.equals(that.dugaar) : that.dugaar != null) return false;
        if (ehZug != null ? !ehZug.equals(that.ehZug) : that.ehZug != null) return false;
        if (shugamHooloiId != null ? !shugamHooloiId.equals(that.shugamHooloiId) : that.shugamHooloiId != null)
            return false;
        if (suulgaltGun != null ? !suulgaltGun.equals(that.suulgaltGun) : that.suulgaltGun != null) return false;
        if (tailbar != null ? !tailbar.equals(that.tailbar) : that.tailbar != null) return false;
        if (torol != null ? !torol.equals(that.torol) : that.torol != null) return false;
        if (tugsZug != null ? !tugsZug.equals(that.tugsZug) : that.tugsZug != null) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shugamHooloiId != null ? shugamHooloiId.hashCode() : 0;
        result = 31 * result + (dugaar != null ? dugaar.hashCode() : 0);
        result = 31 * result + (ehZug != null ? ehZug.hashCode() : 0);
        result = 31 * result + (tugsZug != null ? tugsZug.hashCode() : 0);
        result = 31 * result + (diameter != null ? diameter.hashCode() : 0);
        result = 31 * result + (suulgaltGun != null ? suulgaltGun.hashCode() : 0);
        result = 31 * result + (achaalal != null ? achaalal.hashCode() : 0);
        result = 31 * result + (tailbar != null ? tailbar.hashCode() : 0);
        result = 31 * result + (torol != null ? torol.hashCode() : 0);
        result = 31 * result + (barilgaDugaar != null ? barilgaDugaar.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
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
    @JoinColumn(name = "tugs_hudag_id", referencedColumnName = "hudag_id")
    public HudagEntity getTugsHudag() {
        return tugsHudag;
    }

    public void setTugsHudag(HudagEntity tugsHudag) {
        this.tugsHudag = tugsHudag;
    }

    @ManyToOne
    @JoinColumn(name = "eh_hudag_id", referencedColumnName = "hudag_id")
    public HudagEntity getEhHudag() {
        return ehHudag;
    }

    public void setEhHudag(HudagEntity ehHudag) {
        this.ehHudag = ehHudag;
    }

    @ManyToOne
    @JoinColumn(name = "eh_hudag_shugam_id", referencedColumnName = "hudag_shugam_id")
    public HudagShugamEntity getEhHudagShugam() {
        return ehHudagShugam;
    }

    public void setEhHudagShugam(HudagShugamEntity ehHudagShugam) {
        this.ehHudagShugam = ehHudagShugam;
    }

    @ManyToOne
    @JoinColumn(name = "tugs_hudag_shugam_id", referencedColumnName = "hudag_shugam_id")
    public HudagShugamEntity getTugsHudagShugam() {
        return tugsHudagShugam;
    }

    public void setTugsHudagShugam(HudagShugamEntity tugsHudagShugam) {
        this.tugsHudagShugam = tugsHudagShugam;
    }

    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "material_id")
    public MaterialEntity getMaterial() {
        return material;
    }

    public void setMaterial(MaterialEntity material) {
        this.material = material;
    }
}
