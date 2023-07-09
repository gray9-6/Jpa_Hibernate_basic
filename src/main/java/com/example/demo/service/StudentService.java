package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

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

    public Student getStudentById(int rollNo){

        // find by id will help us to search a record based on the primary key,
        // this is not necessary that we wll always get the object,
        // sometimes we can also get the null value when it does not exists in database
        // so Optional is an inbuilt class in java, which represents it might be null or it might not be null
        // means if this roll no. exists in database then it will give the object of student
        // and if the roll no. doesn't exists then it will give the null value
       Optional<Student> optionalStudent =  studentRepository.findById(rollNo);

       // if the student is present then return the student with get method of jpa interface
       if(optionalStudent.isPresent()){
           return optionalStudent.get();
       }

       // if it's not present then return the null
       return  null;
    }
}
