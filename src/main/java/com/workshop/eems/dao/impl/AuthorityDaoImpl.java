package com.workshop.eems.dao.impl;

import com.workshop.eems.dao.AuthorityDao;
import com.workshop.eems.entity.Authority;
import org.springframework.stereotype.Repository;

/**
 * Created by Wayne on 2015/7/20.
 */
@Repository("authorityDaoImpl")
public class AuthorityDaoImpl extends BaseDaoImpl<Authority, Long> implements AuthorityDao {
}
