package com.bx.springvue.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class RequestAspect {
    /**
     * 任意返回值
     * 任意类
     * 任意方法
     * 任意参数
     **/
    @Pointcut("execution(public * com.bx.springvue.Controller.User.*(..))")
    public void checkRequest(){

    }

    @Before("checkRequest()")
    public void doBefore(JoinPoint joinPoint){
//        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = sra.getRequest();
//        System.out.println(joinPoint.getArgs());
    }
}
