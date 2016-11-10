package com.workshop.eems.service.impl;

import com.workshop.eems.dao.LogDao;
import com.workshop.eems.entity.Log;
import com.workshop.eems.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("logServiceImpl")
public class LogServiceImpl extends BaseServiceImpl<Log, Long> implements
        LogService {

    @Resource(name = "logDaoImpl")
    private LogDao logDao;

    @Resource(name = "logDaoImpl")
    public void setBaseDao(LogDao logDao) {
        super.setBaseDao(logDao);
    }

    public void clear() {
        logDao.removeAll();
    }

}