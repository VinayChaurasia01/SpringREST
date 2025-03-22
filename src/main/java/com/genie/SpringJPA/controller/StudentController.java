package com.genie.SpringJPA.controller;

import com.genie.SpringJPA.entity.Student;
import com.genie.SpringJPA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/std")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/post")
    public Student createStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @GetMapping("/getAll")
    public List<Student> create(){
       return service.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student findByID(@PathVariable Integer id){
        return service.getByID(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id ,@RequestBody Student student){
        Student updatedStu = service.updateStudent(id,student);
        return updatedStu;
    }

    @DeleteMapping("/deleteAll")
    public void delete(){
        service.deleteAllStudent();
    }


    @DeleteMapping("{id}")
    public void deleteById(@PathVariable int id){
        service.deleteStudentById(id);
    }

}
