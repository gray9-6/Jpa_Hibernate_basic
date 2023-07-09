package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add_student")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        String response = studentService.addStudent(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("get_student_by_id")
    public ResponseEntity getStudentById(@RequestParam("rollNo") int rollNo){
        Student student = studentService.getStudentById(rollNo);
        if(student == null){
            return new ResponseEntity<>("Invalid roll Number",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(student,HttpStatus.FOUND);
    }
}
