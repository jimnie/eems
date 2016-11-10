package com.workshop.eems.service;

import com.workshop.eems.entity.ThemeCategory;

/**
 * Created by Wayne on 2016/3/10.
 */
public interface ThemeCategoryService extends BaseService<ThemeCategory, Long> {

    boolean isCategoryNameExists(String categoryName);

    boolean isCategoryNameExists(String categoryName, Long id);
}
