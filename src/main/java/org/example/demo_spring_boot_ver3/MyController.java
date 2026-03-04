package org.example.demo_spring_boot_ver3;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class MyController {
//    @Autowired

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

////    @Qualifier("myPrinter") //由@Bean創建
////    @Qualifier("canonPrinter") //由@Component創建  較常見
//    private Printer printer;
//    @RequestMapping("/test")
//    public String test(){
//        printer.printText("Hi Spring boot");
//        return " world!";
//    }
//}


@RestController
public class MyController {
    @RequestMapping("/product")
    public Store product(){
        List<String> list = new ArrayList<>();

        list.add("橘子");
        list.add("蘋果");

        Store store = new Store();
        store.setProductList(list);
        return store;
    }

    @RequestMapping("/user")
    public Student user(){
        Student student = new Student();
        student.setName("judy");
        student.setId(111);
        return student;
    }

    @RequestMapping("/test1")
    public String test1(@RequestParam Integer id
            ,@RequestParam (name="user_name")String name){
        System.out.println("id: "+id);
        System.out.println("name:  "+ name);
        return "200!!";
    }

    @RequestMapping("/test2")
    public String test2(@RequestBody Student student){
        System.out.println("student id : "+student.getId());
        return "@200!";
    }

    @RequestMapping("/test3")
    public String test3(@RequestHeader String info){
        System.out.println("info: "+ info);
        return "200 header";
    }

    @RequestMapping("/test4/{id}/{name}")
    public String test4(@PathVariable Integer id,
                        @PathVariable String name){
        System.out.println("id: "+ id);
        System.out.println("name: " + name);
        return "test4";
    }

    @RequestMapping("/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Hello World");
    }

    @RequestMapping("/test5")
    public String test5(){
         throw new RuntimeException("test5 error");
    }

    @RequestMapping("/test6")
    public String test6(){
        throw new IllegalArgumentException("test6 error");
    }

    @RequestMapping("/test7")
    public String test7(){
        System.out.println("Test7");
        return "test7";
    }

    @RequestMapping("/test8")
    public String test8(){
        System.out.println("Test8");
        return "test8";
    }
}