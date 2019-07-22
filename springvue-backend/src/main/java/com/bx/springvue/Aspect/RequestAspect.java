package com.bx.springvue.Aspect;

import com.bx.springvue.Exception.TokenException;
import com.bx.springvue.Service.TokenService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class RequestAspect {
    /**
     * 任意返回值
     * 任意类
     * 任意方法
     * 任意参数
     **/
    Logger logger = LoggerFactory.getLogger(RequestAspect.class);
    @Pointcut("execution(public * com.bx.springvue.Controller.User.*(..))")
    public void checkRequest(){
    }

    @Before("checkRequest()")
    public void doBefore(JoinPoint joinPoint) throws TokenException {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
//        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if(method.getName().equals("login")) {
            logger.info("在首页不用检查token");
        }else{
            String t = request.getHeader("token");
            if(TokenService.verifyToken(t)){
            }else{
                throw new TokenException("Unauthorized token");
            }
        }
    }
}
