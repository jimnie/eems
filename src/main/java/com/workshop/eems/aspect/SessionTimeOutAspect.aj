package com.workshop.eems.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Wayne on 2016/7/12.
 */
@Aspect
@Component
public class SessionTimeOutAspect {
    private static Logger logger = LoggerFactory.getLogger(SessionTimeOutAspect.class);

    public SessionTimeOutAspect() {
    }

    @Pointcut("execution(public * com.educonsulting.mms.controller..*.*(..))")
    public void controllerPointcut() {
    }

    @Pointcut("execution(public * com.workshop.eems.controller.BaseController.*(..))")
    public void rootPointcut() {//登录登出功能不需要Session验证
    }

    @Pointcut("controllerPointcut()&&(!rootPointcut())")
    public void sessionTimeOutPointcut() {
    }

    @Around("sessionTimeOutPointcut()")
    public Object sessionTimeOutAdvice(ProceedingJoinPoint pjp) throws IOException {
        Object result = null;
        String targetName = pjp.getTarget().getClass().getSimpleName();
        String methodName = pjp.getSignature().getName();
        logger.info("----------------执行方法-----------------");
        logger.info("类名：" + targetName + " 方法名：" + methodName);
        HttpServletResponse response = null;
        for (Object param : pjp.getArgs()) {
            if (param instanceof HttpServletResponse) {
                response = (HttpServletResponse) param;
            }
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        if (session.getAttribute("loginname") != null) {
            try {
                result = pjp.proceed();
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return result;
        } else {
            logger.debug("Session已超时，正在跳转回登录页面");
            response.sendRedirect(request.getContextPath());
        }
        return result;
    }
}
