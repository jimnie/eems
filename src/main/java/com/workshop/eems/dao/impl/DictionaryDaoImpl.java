package com.workshop.eems.dao.impl;

import com.workshop.eems.common.Filter;
import com.workshop.eems.common.Order;
import com.workshop.eems.dao.DictionaryDao;
import com.workshop.eems.entity.Dictionary;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wayne on 2015/7/4.
 */
@Repository("dictionaryDaoImpl")
public class DictionaryDaoImpl extends BaseDaoImpl<Dictionary, Long> implements DictionaryDao {

    public List<Dictionary> findDict(String fieldName) {
        if (StringUtils.isEmpty(fieldName)) {
            return null;
        }

        Filter filter = new Filter("nickname", Filter.Operator.eq, fieldName);
        List<Filter> filters = new ArrayList<Filter>();
        filters.add(filter);

        Order order = new Order("sortNo", Order.Direction.asc);
        List<Order> orders = new ArrayList<Order>();
        orders.add(order);

        return findList(null, null, filters, orders);
    }
}
