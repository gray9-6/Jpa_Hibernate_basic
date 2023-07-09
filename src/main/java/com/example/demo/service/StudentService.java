package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent( Student student){
        //the JpaRepository interface have the save method to add the object into database
        // and since the student repository interface is extending the jpa repository interface,
        // with the help of student repository object we can call that save method
        // and will be able to add the object (student) into the database;
        studentRepository.save(student);
        return "Student added Successfully";
    }
}
