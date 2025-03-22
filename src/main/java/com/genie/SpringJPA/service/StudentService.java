package com.genie.SpringJPA.service;

import com.genie.SpringJPA.entity.Student;
import com.genie.SpringJPA.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;


    public Student saveStudent(Student student){
        return studentRepo.save(student);
    }

    public List<Student> getAllStudent(){
         List<Student> studentsList =studentRepo.findAll();
         return studentsList;
    }


    public Student getByID(Integer id){

        Optional<Student> ID = studentRepo.findById(id);
        Student student = ID.get();
        return student;
    }

    public Student updateStudent(Integer id , Student student){

        Optional<Student> studentById = studentRepo.findById(id);

        Student s = null;

        if(studentById.isPresent()){
            Student dbStudentObject = studentById.get();
            dbStudentObject.setAge(student.getAge());
            dbStudentObject.setEmail(student.getEmail());
            dbStudentObject.setId(student.getId());
            dbStudentObject.setName(student.getName());

            s = studentRepo.save(dbStudentObject);
        }else{
            System.out.println("Data not present in DataBase");
        }

        return s;
    }

    public void deleteAllStudent(){
        studentRepo.deleteAll();
    }

    public void deleteStudentById(int id){
        studentRepo.deleteById(id);
    }


}
