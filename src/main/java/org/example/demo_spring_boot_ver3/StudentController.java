package org.example.demo_spring_boot_ver3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @PostMapping("/students")
    public String insert(@RequestBody Student student){

        studentRepository.save(student);
        return "執行資料庫create 操作";
    }

    @GetMapping("/students/{studentId}")
    public Student getById(@PathVariable Integer studentId){
        return studentRepository.findById(studentId).orElse(null);
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody  Student student){
        student.setId(studentId);

        Student s = studentRepository.findById(studentId).orElse(null);

        if(s != null){
            s.setName(student.getName());
            studentRepository.save(s);
            return "執行update";
        }else {
            return "更新失敗 資料不存在";
        }


    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId){
        studentRepository.deleteById(studentId);
        return "執行delete";
    }

}
