package com.workshop.eems.dao;

import com.workshop.eems.entity.Group;

/**
 * Created by Wayne on 2015/7/7.
 */
public interface GroupDao extends BaseDao<Group, Long> {
    Group findRoot();

    boolean isTagNameExists(String tag);
}
