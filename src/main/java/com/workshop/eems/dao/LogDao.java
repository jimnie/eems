package com.workshop.eems.dao;

import com.workshop.eems.entity.Log;

public interface LogDao extends BaseDao<Log, Long> {

    void removeAll();

}