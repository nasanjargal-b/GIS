package com.monsource.geotsenoz.data.entity;

import com.monsource.geotsenoz.core.data.DataEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by nasanjargal on 6/11/14.
 */
@Entity
@Table(name = "tag", schema = "public", catalog = "geo")
public class TagEntity implements DataEntity {
    private Integer tagId;
    private String name;
    private Set<HudagEntity> hudags;

    @Id
    @Column(name = "tag_id")
    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TagEntity tagEntity = (TagEntity) o;

        if (name != null ? !name.equals(tagEntity.name) : tagEntity.name != null) return false;
        if (tagId != null ? !tagId.equals(tagEntity.tagId) : tagEntity.tagId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tagId != null ? tagId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tag")
    public Set<HudagEntity> getHudags() {
        return hudags;
    }

    public void setHudags(Set<HudagEntity> hudags) {
        this.hudags = hudags;
    }
}
