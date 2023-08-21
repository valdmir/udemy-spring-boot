package com.bivala.backend.rest;

import com.bivala.backend.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> studentList;


    @PostConstruct
    public void loadData(){
        studentList=new ArrayList<>();
        studentList.add(new Student("Freddy","Wijaya"));
        studentList.add(new Student("Melisa","Wijaya"));
        studentList.add(new Student("Axel Xavier","Wijaya"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){

        return studentList;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if(studentId<0||studentId>studentList.size()){
            throw new  StudentNotFoundException("student ID not found - "+studentId);
        }
        return studentList.get(studentId);
    }

}
