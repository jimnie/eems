package com.workshop.eems.service.impl;

import com.workshop.eems.common.Filter;
import com.workshop.eems.common.Order;
import com.workshop.eems.common.Page;
import com.workshop.eems.common.Pageable;
import com.workshop.eems.dao.ActDao;
import com.workshop.eems.entity.Act;
import com.workshop.eems.service.ActService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Wayne on 2015/7/16.
 */
@Service("actServiceImpl")
public class ActServiceImpl extends BaseServiceImpl<Act, Long> implements ActService {

    @Resource(name = "actDaoImpl")
    private ActDao actDao;

    @Resource(name = "actDaoImpl")
    private void setBaseDao(ActDao actDao) {
        super.setBaseDao(actDao);
    }

    public boolean isAliasExists(String tag) {
        return actDao.isAliasExists(tag);
    }

    @Override
    @Cacheable(value = "act")
    public Act find(Long id) {
        return super.find(id);
    }

    @Override
    @Cacheable(value = "act")
    public List<Act> findAll() {
        return super.findAll();
    }

    @Override
    @Cacheable(value = "act")
    public List<Act> findList(Long... ids) {
        return super.findList(ids);
    }

    @Override
    @Cacheable(value = "act")
    public List<Act> findList(Integer count, List<Filter> filters, List<Order> orders) {
        return super.findList(count, filters, orders);
    }

    @Override
    @Cacheable(value = "act")
    public List<Act> findList(Integer first, Integer count, List<Filter> filters, List<Order>
            orders) {
        return super.findList(first, count, filters, orders);
    }

    @Override
    @Cacheable(value = "act")
    public Page<Act> findPage(Pageable pageable) {
        return super.findPage(pageable);
    }

    @Override
    @CacheEvict(value = "act", allEntries = true)
    public void save(Act entity) {
        super.save(entity);
    }

    @Override
    @CacheEvict(value = "act", allEntries = true)
    public Act update(Act entity) {
        return super.update(entity);
    }

    @Override
    @CacheEvict(value = "act", allEntries = true)
    public Act update(Act entity, String... ignoreProperties) {
        return super.update(entity, ignoreProperties);
    }

    @Override
    @CacheEvict(value = "act", allEntries = true)
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    @CacheEvict(value = "act", allEntries = true)
    public void delete(Long... ids) {
        super.delete(ids);
    }

    @Override
    @CacheEvict(value = "act", allEntries = true)
    public void delete(Act entity) {
        super.delete(entity);
    }
}
