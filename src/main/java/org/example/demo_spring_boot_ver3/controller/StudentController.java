package org.example.demo_spring_boot_ver3.controller;

import org.example.demo_spring_boot_ver3.model.Student;
import org.example.demo_spring_boot_ver3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private NamedParameterJdbcTemplate  namedParameterJdbcTemplate;

    @PostMapping("/students")
    public String insert (@RequestBody Student student){
        return studentService.insert(student);
    }

    @PostMapping("/students/batch")
    public String InsertList(@RequestBody List<Student> studentList){
        return studentService.insertList(studentList);
    }

    @DeleteMapping("/students/{studentId}")
    public String delete (@PathVariable Integer studentId){
       return studentService.delete(studentId);
    }

    @GetMapping("/students")
    public List<Student> select(){
        return studentService.select();
    }

    @GetMapping("/students/{studentId}")
    public Student selectById(@PathVariable Integer studentId){
       return  studentService.getById(studentId);
    }
}
