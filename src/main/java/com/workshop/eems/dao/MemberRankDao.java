package com.workshop.eems.dao;

import com.workshop.eems.entity.MemberRank;

import java.math.BigDecimal;

public interface MemberRankDao extends BaseDao<MemberRank, Long> {

    boolean nameExists(String name);

    boolean amountExists(BigDecimal amount);

    MemberRank findDefault();

    MemberRank findByAmount(BigDecimal amount);

}