package com.genie.SpringJPA.controller;

import com.genie.SpringJPA.entity.Student;
import com.genie.SpringJPA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/std")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/post")
    public Student createStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    /*@GetMapping("/get")
    public Student create*/
}
