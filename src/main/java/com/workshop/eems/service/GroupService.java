package com.workshop.eems.service;

import com.workshop.eems.entity.Group;

/**
 * Created by Wayne on 2015/7/7.
 */
public interface GroupService extends BaseService<Group, Long> {

    Object getTree();

    Group findRoot();

    Group findGroup(Long id);

    boolean isTagNameExists(String tag);
}
