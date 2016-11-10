package com.workshop.eems.service;

import com.workshop.eems.entity.Area;

import java.util.List;

public interface AreaService extends BaseService<Area, Long> {

    List<Area> findRoots();

    List<Area> findRoots(Integer count);

    List<Area> getAresByParent(Long id);

}