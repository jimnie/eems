package com.workshop.eems.service;

import com.workshop.eems.Page;
import com.workshop.eems.Pageable;
import com.workshop.eems.entity.Member;
import com.workshop.eems.entity.RechargeLog;
import com.workshop.eems.entity.User;

/**
 * Created by Wayne on 2016/3/7.
 */
public interface MemberService extends BaseService<Member, Long> {

    boolean isCartNoAssigned(String cardNo);

    boolean isMobileExisted(String mobile);

    Page<Member> findPage(Pageable pageable);

    void update(Member member, User user, RechargeLog.Type type);

}
