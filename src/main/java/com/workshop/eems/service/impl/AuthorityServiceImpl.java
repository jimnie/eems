package com.workshop.eems.service.impl;

import com.workshop.eems.dao.AuthorityDao;
import com.workshop.eems.entity.Authority;
import com.workshop.eems.service.AuthorityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Wayne on 2015/7/20.
 */
@Service("authorityServiceImpl")
public class AuthorityServiceImpl extends BaseServiceImpl<Authority, Long> implements
        AuthorityService {

    @Resource(name = "authorityDaoImpl")
    private AuthorityDao authorityDao;

    @Resource(name = "authorityDaoImpl")
    private void setBaseDao(AuthorityDao authorityDao) {
        super.setBaseDao(authorityDao);
    }
}
