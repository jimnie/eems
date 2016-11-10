package com.workshop.eems.service;

import com.workshop.eems.entity.Log;

public interface LogService extends BaseService<Log, Long> {

    void clear();

}