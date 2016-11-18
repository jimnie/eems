package com.workshop.eems.service;

import com.workshop.eems.common.Page;
import com.workshop.eems.common.Pageable;
import com.workshop.eems.entity.Employee;

/**
 * Created by Wayne on 2016/3/7.
 */
public interface EmployeeService extends BaseService<Employee, Long> {

    boolean isCartNoAssigned(String cardNo);

    boolean isMobileExisted(String mobile);

    Page<Employee> findPage(Pageable pageable);

}
