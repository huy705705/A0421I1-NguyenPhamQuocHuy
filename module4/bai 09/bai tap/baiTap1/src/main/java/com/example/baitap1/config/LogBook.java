package com.example.baitap1.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogBook {
    @AfterReturning("execution(public * com.example.baitap1.service.BookService.*(..)))")
    public void logBookService(JoinPoint joinPoint){
        String className=joinPoint.getTarget().getClass().getSimpleName();
        String methodName=joinPoint.getSignature().getName();
        System.err.println("Class là: "+className+"Va method la: "+methodName);
    }

    @AfterThrowing(value = "execution(public * com.example.baitap1.service.BookService.*(..)))",throwing = "e")
    public  void logException(JoinPoint joinPoint,Exception e){
        String className=joinPoint.getTarget().getClass().getSimpleName();
        String methodName=joinPoint.getSignature().getName();
        System.err.println("Class la: "+className+" Va method la: "+methodName+" "+e.getMessage());
    }
}
