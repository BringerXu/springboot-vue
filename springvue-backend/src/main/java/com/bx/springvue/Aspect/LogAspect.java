package com.bx.springvue.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogAspect {
    /**
     * 任意返回值
     * 任意类
     * 任意方法
     * 任意参数
    **/
    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(public * com.bx.springvue.Controller.*.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        logger.debug("url:"+request.getRequestURL());
        logger.debug("ip:"+request.getRemoteHost());
        logger.debug("method:"+request.getMethod());
        logger.debug("class_method"+joinPoint.getSignature().getDeclaringTypeName()+","
                +joinPoint.getSignature().getName());
        logger.debug("params"+joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("After execution: ");
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doReturn(Object result){
        logger.info("Returning: "+result.toString());
    }
}
