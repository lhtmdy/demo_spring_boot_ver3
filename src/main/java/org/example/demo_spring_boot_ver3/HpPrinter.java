package org.example.demo_spring_boot_ver3;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HpPrinter implements Printer {
//    @Value("${printer.count}")
//    :後面是預設
//    @Value("${printer.count:5}")

    private int count;

    @PostConstruct
    public void init(){
        count = 5;

    }
    @Override
    public void printText(String message) {
        count--;
        System.out.println("HP印表機"+message);
        System.out.println("HP 印表機剩下"+count+"次");
//     sout  System.out.println();
    }
}
