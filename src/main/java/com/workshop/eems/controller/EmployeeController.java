package com.workshop.eems.controller;

import com.workshop.eems.common.*;
import com.workshop.eems.entity.Employee;
import com.workshop.eems.service.EmployeeService;
import com.workshop.eems.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wayne on 2016/3/7.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController extends BaseController {

    @Resource(name = "employeeServiceImpl")
    private EmployeeService employeeService;

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/member/index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(@RequestParam(value = "rows", required = false) String rows,
                       @RequestParam(value = "page", required = false) String page,
                       @RequestParam(value = "sort", required = false) String sort,
                       @RequestParam(value = "order", required = false) String order,
                       @RequestParam(value = "cardNo", required = false) String cardNo,
                       @RequestParam(value = "kidName", required = false) String kidName,
                       @RequestParam(value = "mobile", required = false) String mobile
    ) {
        Pageable pageable = getPageable(rows, page, sort, order);
        List<Filter> filters = new ArrayList<Filter>();
        if (StringUtils.isNotEmpty(cardNo)) {
            filters.add(Filter.eq("cardNo", cardNo));
        }
        if (StringUtils.isNotEmpty(kidName)) {
            filters.add(Filter.eq("firstKidCnName", kidName));
        }
        if (StringUtils.isNotEmpty(mobile)) {
            filters.add(Filter.eq("mobile", mobile));
        }
        pageable.setFilters(filters);
        Page<Employee> memberPage = employeeService.findPage(pageable);
        return getPageResultMap(memberPage);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Message save(Employee member, @RequestParam(value = "activities") String str) {
        if (employeeService.isCartNoAssigned(member.getCardNo())) {
            return Message.error("member.form.cardNoIsExist");
        }
        if (employeeService.isMobileExisted(member.getMobile())) {
            return Message.error("member.form.mobileExist");
        }
        String[] ids = str.split(",");
        member.setPoint(CommonAttributes.DEFAULT_MEMBER_POINT);
        member.setBalance(BigDecimal.ZERO);
        member.setAmount(BigDecimal.ZERO);
        employeeService.save(member);
        return SUCCESS_MESSAGE;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Message update(Employee member, @RequestParam(value = "activities") String str) {
        if (employeeService.isCartNoAssigned(member.getCardNo())) {
            return Message.error("member.form.cardNoIsExist");
        }
        if (employeeService.isMobileExisted(member.getMobile())) {
            return Message.error("member.form.mobileExist");
        }
        String[] ids = str.split(",");
        employeeService.update(member, "cartNo", "amount", "balance", "point", "registerDate");
        return SUCCESS_MESSAGE;
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query() {
        return "/member/query";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Message delete(@RequestParam(value = "memberId") String id) {
        employeeService.delete(Long.valueOf(id));
        return SUCCESS_MESSAGE;
    }

    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    @ResponseBody
    public Message recharge(@RequestParam(value = "c_id") String id,
                            @RequestParam(value = "rechargeAmount") String amount) {
        Employee member = employeeService.find(Long.valueOf(id));
        member.setRechargeAmount(BigDecimal.valueOf(Double.valueOf(amount)));
        member.setAmount(member.getAmount().add(member.getRechargeAmount()));
        member.setBalance(member.getBalance().add(member.getRechargeAmount()));
        member.setPoint(member.getPoint() + member.getRechargeAmount().longValue());

        employeeService.update(member);
        return SUCCESS_MESSAGE;
    }

    @RequestMapping(value = "/unrecharge", method = RequestMethod.POST)
    @ResponseBody
    public Message unrecharge(@RequestParam(value = "b_id") String id,
                              @RequestParam(value = "unrechargeAmount") String amount,
                              @RequestParam(value = "cause") String cause) {
        Employee member = employeeService.find(Long.valueOf(id));
        member.setRechargeAmount(BigDecimal.valueOf(Double.valueOf(amount)).negate());
        member.setAmount(member.getAmount().add(member.getRechargeAmount()));
        member.setBalance(member.getBalance().add(member.getRechargeAmount()));
        member.setPoint(member.getPoint() + member.getRechargeAmount().longValue());

        employeeService.update(member);
        return SUCCESS_MESSAGE;
    }
}
