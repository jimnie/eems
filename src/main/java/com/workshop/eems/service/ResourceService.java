package com.workshop.eems.service;

import com.workshop.eems.entity.Resources;

/**
 * Created by Wayne on 2015/7/12.
 */
public interface ResourceService extends BaseService<Resources, Long> {

    Object getTree();

    Resources findParents();

    Resources findSubnodes(String id);

    boolean isAliasNameExists(String aliasName);
}
