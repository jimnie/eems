package com.workshop.eems.service.impl;

import com.workshop.eems.common.Filter;
import com.workshop.eems.common.Order;
import com.workshop.eems.common.Page;
import com.workshop.eems.common.Pageable;
import com.workshop.eems.dao.EmployeeDao;
import com.workshop.eems.entity.Employee;
import com.workshop.eems.service.EmployeeService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Wayne on 2016/3/8.
 */
@Service("employeeServiceImpl")
public class EmployeeServiceImpl extends BaseServiceImpl<Employee, Long> implements
        EmployeeService {

    @Resource(name = "employeeDaoImpl")
    private EmployeeDao employeeDao;

    @Resource(name = "employeeDaoImpl")
    public void setBaseDao(EmployeeDao employeeDao) {
        super.setBaseDao(employeeDao);
    }

    @Transactional(readOnly = true)
    public boolean cartNoExists(String cardNo) {
        return employeeDao.isCardNoAssigned(cardNo);
    }

    @Override
    public List<Employee> findList(Long... ids) {
        return super.findList(ids);
    }

    @Override
    public List<Employee> findList(Integer count, List<Filter> filters, List<Order> orders) {
        return super.findList(count, filters, orders);
    }

    @Override
    public List<Employee> findList(Integer first, Integer count, List<Filter> filters, List<Order>
            orders) {
        return super.findList(first, count, filters, orders);
    }

    @Override
    public long count() {
        return super.count();
    }

    @Override
    public long count(Filter... filters) {
        return super.count(filters);
    }

    @Override
    public boolean exists(Long id) {
        return super.exists(id);
    }

    @Override
    public boolean exists(Filter... filters) {
        return super.exists(filters);
    }

    @Override
    public Employee find(Long id) {
        return super.find(id);
    }

    @Override
    @Cacheable(value = "employee")
    public List<Employee> findAll() {
        return super.findAll();
    }

    @Override
    @Cacheable(value = "employee")
    public Page<Employee> findPage(Pageable pageable) {
        return super.findPage(pageable);
    }

    @Override
    @CacheEvict(value = "employee", allEntries = true)
    public void save(Employee entity) {
        super.save(entity);
    }

    @Override
    @CacheEvict(value = "employee", allEntries = true)
    public Employee update(Employee entity) {
        return super.update(entity);
    }

    @Override
    @CacheEvict(value = "employee", allEntries = true)
    public Employee update(Employee entity, String... ignoreProperties) {
        return super.update(entity, ignoreProperties);
    }

    @Override
    @CacheEvict(value = "employee", allEntries = true)
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    @CacheEvict(value = "employee", allEntries = true)
    public void delete(Long... ids) {
        super.delete(ids);
    }

    @Override
    @CacheEvict(value = "employee", allEntries = true)
    public void delete(Employee entity) {
        super.delete(entity);
    }

    @Override
    public boolean isCartNoAssigned(String cardNo) {
        return employeeDao.isCardNoAssigned(cardNo);
    }

    @Override
    public boolean isMobileExisted(String mobile) {
        return employeeDao.isMobileExisted(mobile);
    }

}
