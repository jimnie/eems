package com.workshop.eems.listener;

import com.workshop.eems.entity.BaseEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class EntityListener {

    @PrePersist
    public void prePersist(BaseEntity entity) {
        entity.setCreateDate(new Date());
        entity.setModifyDate(new Date());
    }

    @PreUpdate
    public void preUpdate(BaseEntity entity) {
        entity.setModifyDate(new Date());
    }

}