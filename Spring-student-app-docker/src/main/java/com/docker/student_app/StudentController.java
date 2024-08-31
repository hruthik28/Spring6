package com.docker.student_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/getStudents")
    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    @RequestMapping("/addStudent")
    public void addStudent(){
        Student s =new Student();
        s.setName("SDHUI");
        s.setAge(10);
        studentRepo.save(s);
    }

}
