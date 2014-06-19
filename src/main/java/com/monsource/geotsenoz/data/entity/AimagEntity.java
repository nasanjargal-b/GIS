package com.monsource.geotsenoz.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.monsource.geotsenoz.core.data.DataEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by nasanjargal on 6/11/14.
 */
@Entity
@Table(name = "aimag", schema = "public", catalog = "geo")
public class AimagEntity implements DataEntity {
    private Integer aimagId;
    private String aimagName;
    private Set<HudagEntity> hudags;
    private Set<ShugamHooloiEntity> shugamHoolois;

    @Id
    @Column(name = "aimag_id")
    public Integer getAimagId() {
        return aimagId;
    }

    public void setAimagId(Integer aimagId) {
        this.aimagId = aimagId;
    }

    @Basic
    @Column(name = "aimag_name")
    public String getAimagName() {
        return aimagName;
    }

    public void setAimagName(String aimagName) {
        this.aimagName = aimagName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AimagEntity that = (AimagEntity) o;

        if (aimagId != null ? !aimagId.equals(that.aimagId) : that.aimagId != null) return false;
        if (aimagName != null ? !aimagName.equals(that.aimagName) : that.aimagName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aimagId != null ? aimagId.hashCode() : 0;
        result = 31 * result + (aimagName != null ? aimagName.hashCode() : 0);
        return result;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "aimag")
    public Set<HudagEntity> getHudags() {
        return hudags;
    }

    public void setHudags(Set<HudagEntity> hudags) {
        this.hudags = hudags;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "aimag")
    public Set<ShugamHooloiEntity> getShugamHoolois() {
        return shugamHoolois;
    }

    public void setShugamHoolois(Set<ShugamHooloiEntity> shugamHoolois) {
        this.shugamHoolois = shugamHoolois;
    }
}
