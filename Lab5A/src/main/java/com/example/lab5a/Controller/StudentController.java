package com.example.lab5a.Controller;


import com.example.lab5a.Api.ApiResponse;
import com.example.lab5a.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("Api/va/Student")
public class StudentController {
    ArrayList<Student> students = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Student> studentName() {
        return students;
    }

    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("added");
    }

    @PutMapping("/update/{index}")
    public ApiResponse UpStudent(@PathVariable int index, @RequestBody Student student) {
        students.set(index, student);
        return new ApiResponse("Updated");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse delete(@PathVariable int index) {
        students.remove(index);
        return new ApiResponse("delete");
    }

    @GetMapping("/name/{index}")
    public String getname(@PathVariable int index) {
        return students.get(index).getName();
    }

    @GetMapping("age/{index}")
    public int getage(@PathVariable int index) {
        return students.get(index).getAge();
    }
    @GetMapping("degree/{index}")
    public String getDegree(@PathVariable int index) {
        return students.get(index).getDegree();
    }
    @GetMapping("status/{index}")
    public boolean getstatus(@PathVariable int index) {
        return students.get(index).isStatus();
    }
}