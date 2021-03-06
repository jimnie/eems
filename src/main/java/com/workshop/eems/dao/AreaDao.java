package com.workshop.eems.dao;

import com.workshop.eems.entity.Area;

import java.util.List;

public interface AreaDao extends BaseDao<Area, Long> {

    List<Area> findRoots(Integer count);

    List<Area> getAresByParent(Long id);
}