package com.topiea.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author: kent long
 * @Date: 2018/11/5 上午 10:17
 */
@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(public * com.topiea.controller.*.*(..))")
    public void webLog() {

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        System.out.println("Aspect 方法监视中...");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("URL:"+request.getRequestURL().toString());
        System.out.println("HTTP_METHOD:"+request.getMethod());
        System.out.println("IP:"+request.getRemoteAddr());
        System.out.println("Class_Method"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
    }
    @After("webLog()")
    public void after() {
        System.out.println("webLog after 最后执行...."+new Date());
    }
    @AfterThrowing("webLog()")
    public void afterThrow(JoinPoint joinPoint) {
        System.out.println("执行方法webLog时抛出异常");
    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning (Object ret){
        System.out.println("方法返回值"+ ret);
    }

    @Around("webLog()")
    public Object enArround(ProceedingJoinPoint pjd) {
        System.out.println("方法环绕...");
        try {

            Object o = pjd.proceed();
            System.out.println("方法环绕proceed.结果是:"+o);
            return o;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }

    }
}
