package com.workshop.eems.dao;

import com.workshop.eems.entity.Employee;

/**
 * Created by Wayne on 2016/3/7.
 */
public interface EmployeeDao extends BaseDao<Employee, Long> {

    boolean isCardNoAssigned(String cardNo);

    boolean isMobileExisted(String mobile);
}
