package com.workshop.eems.dao.impl;

import com.workshop.eems.dao.RechargeLogDao;
import com.workshop.eems.entity.RechargeLog;
import org.springframework.stereotype.Repository;

/**
 * Created by Wayne on 2016/5/24.
 */
@Repository("rechargeLogDaoImpl")
public class RechargeLogDaoImpl extends BaseDaoImpl<RechargeLog, Long> implements RechargeLogDao {
}
