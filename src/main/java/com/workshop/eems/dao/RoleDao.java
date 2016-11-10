package com.workshop.eems.dao;

import com.workshop.eems.entity.Role;

public interface RoleDao extends BaseDao<Role, Long> {
    boolean isTagNameExists(String tag);
}