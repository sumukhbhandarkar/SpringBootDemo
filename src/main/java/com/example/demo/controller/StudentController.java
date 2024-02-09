package com.example.demo.controller;

import com.example.demo.model.StudentModel;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping(value = "/getAll")
    public List<StudentModel> getStudentList() {
        return service.getAllStudents();
    }

    @RequestMapping(value = "/getStudentList", method = RequestMethod.GET)
    public List<StudentModel> get() {
        return service.getAllStudents();
    }

    @PostMapping(value = "/addMany")
    public String addManyStudents(List<StudentModel> studentModels) {
        service.addManyStudents(studentModels);
        return "Added " + studentModels.size() + " students";
    }

    @PostMapping(value = "/addStudent")
    public String addStudent(@RequestBody StudentModel studentModel) {
        service.addStudent(studentModel);
        return "Added student: " + studentModel.getUSN();
    }

    @GetMapping(value = "/search/")
    @ResponseBody
    public StudentModel searchStudent(@RequestParam String usn) {
        return service.searchStudent(usn);
    }
}
