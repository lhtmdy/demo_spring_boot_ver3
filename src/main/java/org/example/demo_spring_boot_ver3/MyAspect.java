package org.example.demo_spring_boot_ver3;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect{
//    @Before execution(* org.example.demo_spring_boot.HpPrinter.printText(..))
    @Before("execution(* org.example.demo_spring_boot.HpPrinter.*(..))")
    public void before(){
        System.out.println("I'm before");
    }
}