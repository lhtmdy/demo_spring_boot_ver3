package org.example.demo_spring_boot_ver3;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
//    @Qualifier("myPrinter") //由@Bean創建
//    @Qualifier("canonPrinter") //由@Component創建  較常見
    private Printer printer;
    @RequestMapping("/test")
    public String test(){
        printer.printText("Hi Spring boot");
        return " world!";
    }
}
