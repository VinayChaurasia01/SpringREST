package com.genie.SpringJPA.service;

import com.genie.SpringJPA.entity.Student;
import com.genie.SpringJPA.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;


    public Student saveStudent(Student student){
        return studentRepo.save(student);
    }
}
