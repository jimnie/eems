package com.workshop.eems.service;

import com.workshop.eems.entity.Role;

public interface RoleService extends BaseService<Role, Long> {
    boolean isTagNameExists(String tag);
}