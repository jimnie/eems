package com.workshop.eems.dao.impl;

import com.workshop.eems.dao.EmployeeDao;
import com.workshop.eems.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.FlushModeType;

/**
 * Created by Wayne on 2016/3/8.
 */
@Repository("employeeDaoImpl")
public class EmployeeDaoImpl extends BaseDaoImpl<Employee, Long> implements EmployeeDao {

    @Override
    public boolean isCardNoAssigned(String cardNo) {
        String jpql = "select count(emp) from Employee emp where emp.cardNo = " +
                ":cardNo";
        Long count = entityManager.createQuery(jpql, Long.class).setFlushMode(FlushModeType
                .COMMIT).setParameter("cardNo", cardNo).getSingleResult();
        return count > 0;
    }

    @Override
    public boolean isMobileExisted(String mobile) {
        String jpql = "select count(emp.mobile) from Employee emp where emp.mobile = :mobile";
        Long count = entityManager.createQuery(jpql, Long.class).setFlushMode(FlushModeType.COMMIT)
                .setParameter("mobile", mobile).getSingleResult();
        return count > 0;
    }
}
