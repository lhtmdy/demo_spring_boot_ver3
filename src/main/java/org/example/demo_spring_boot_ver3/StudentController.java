package org.example.demo_spring_boot_ver3;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @PostMapping("/students")
//    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String create(@RequestBody @Valid Student student){
//        if(student.getId() ==null){
//            throw new RuntimeException("id 不可為null");
//        }
        return "執行資料庫create操作";
    }

    @GetMapping("/students/{studentId}")
    public String read(@PathVariable Integer studentId){
        return "執行資料庫的 Read 操作";
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student){
        return "執行資料庫Update 操作";
    }

    @DeleteMapping("/stdents/{studentId}")
    public String delete(@PathVariable Integer studentId){
        return  "執行資料庫的Delete操作";
    }
}
