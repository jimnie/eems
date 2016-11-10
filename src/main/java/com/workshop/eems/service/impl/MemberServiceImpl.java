package com.workshop.eems.service.impl;

import com.workshop.eems.Filter;
import com.workshop.eems.Order;
import com.workshop.eems.Page;
import com.workshop.eems.Pageable;
import com.workshop.eems.dao.MemberDao;
import com.workshop.eems.dao.RechargeLogDao;
import com.workshop.eems.entity.Member;
import com.workshop.eems.entity.User;
import com.workshop.eems.service.MemberService;
import com.workshop.eems.entity.RechargeLog;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Wayne on 2016/3/8.
 */
@Service("memberServiceImpl")
public class MemberServiceImpl extends BaseServiceImpl<Member, Long> implements MemberService {

    @Resource(name = "memberDaoImpl")
    private MemberDao memberDao;

    @Resource(name = "rechargeLogDaoImpl")
    private RechargeLogDao rechargeLogDao;

    @Resource(name = "memberDaoImpl")
    public void setBaseDao(MemberDao memberDao) {
        super.setBaseDao(memberDao);
    }

    @Transactional(readOnly = true)
    public boolean cartNoExists(String cardNo) {
        return memberDao.isCardNoAssigned(cardNo);
    }

    @Override
    public List<Member> findList(Long... ids) {
        return super.findList(ids);
    }

    @Override
    public List<Member> findList(Integer count, List<Filter> filters, List<Order> orders) {
        return super.findList(count, filters, orders);
    }

    @Override
    public List<Member> findList(Integer first, Integer count, List<Filter> filters, List<Order>
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
    public Member find(Long id) {
        return super.find(id);
    }

    @Override
    @Cacheable(value = "member")
    public List<Member> findAll() {
        return super.findAll();
    }

    @Override
    @Cacheable(value = "member")
    public Page<Member> findPage(Pageable pageable) {
        return super.findPage(pageable);
    }

    @Override
    @CacheEvict(value = "member", allEntries = true)
    public void save(Member entity) {
        super.save(entity);
    }

    @Override
    @CacheEvict(value = "member", allEntries = true)
    public Member update(Member entity) {
        return super.update(entity);
    }

    @Override
    @CacheEvict(value = "member", allEntries = true)
    public Member update(Member entity, String... ignoreProperties) {
        return super.update(entity, ignoreProperties);
    }

    @Override
    @CacheEvict(value = "member", allEntries = true)
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    @CacheEvict(value = "member", allEntries = true)
    public void delete(Long... ids) {
        super.delete(ids);
    }

    @Override
    @CacheEvict(value = "member", allEntries = true)
    public void delete(Member entity) {
        super.delete(entity);
    }

    @Override
    public boolean isCartNoAssigned(String cardNo) {
        return memberDao.isCardNoAssigned(cardNo);
    }

    @Override
    public boolean isMobileExisted(String mobile) {
        return memberDao.isMobileExisted(mobile);
    }

    @Transactional
    public void update(Member member, User user, RechargeLog.Type type) {
        Assert.notNull(member);
        BigDecimal rechargeAmount = member.getRechargeAmount();

    }
}
