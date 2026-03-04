package org.example.demo_spring_boot_ver3;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class MyAspect{
    @Around("execution(* org.example.demo_spring_boot_ver3.HpPrinter.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
//        System.out.println("I'm before");
        Date start = new Date();
//        執行切入點的方法
        Object obj = pjp.proceed();

        Date end = new Date();
        long time = end.getTime()- start.getTime();

        System.out.println("start:"+start);
        System.out.println("end:"+end);
        System.out.println("總共執行了:"+time+"ms");
        return  obj;
    }

//    @Before("execution(* org.example.demo_spring_boot_ver3.HpPrinter.*(..))")
//    public void before(){
//        System.out.println("I'm before");
//    }
//
//    @After("execution(* org.example.demo_spring_boot_ver3.HpPrinter.*(..))")
//    public void after(){
//        System.out.println("I'm after");
//    }
}