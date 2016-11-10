package com.workshop.eems.service;

import com.workshop.eems.entity.MemberRank;

import java.math.BigDecimal;

public interface MemberRankService extends BaseService<MemberRank, Long> {

    boolean nameExists(String name);

    boolean nameUnique(String previousName, String currentName);

    boolean amountExists(BigDecimal amount);

    boolean amountUnique(BigDecimal previousAmount, BigDecimal currentAmount);

    MemberRank findDefault();

}