package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add_student")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        String response = studentService.addStudent(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
