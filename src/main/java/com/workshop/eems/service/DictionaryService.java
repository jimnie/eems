package com.workshop.eems.service;

import com.workshop.eems.entity.Dictionary;

import java.util.List;

/**
 * Created by Wayne on 2015/7/4.
 */
public interface DictionaryService extends BaseService<Dictionary, Long> {

    List<Dictionary> findDict(String fieldName);
}
