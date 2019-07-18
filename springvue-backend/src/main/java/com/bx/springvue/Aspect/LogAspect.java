package com.bx.springvue.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
public class LogAspect {
    /**
     * 任意返回值
     * 任意类
     * 任意方法
     * 任意参数
    **/
    @Pointcut("execution(public * com.bx.springvue.Controller.*.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        System.out.println("url:"+request.getRequestURL());
        System.out.println("ip:"+request.getRemoteHost());
        System.out.println("method:"+request.getMethod());
        System.out.println("class_method"+joinPoint.getSignature().getDeclaringTypeName()+","
        +joinPoint.getSignature().getName());
        System.out.println("params"+joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        System.out.println("After execution");
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doReturn(Object result){
        System.out.println(result);
    }
}
