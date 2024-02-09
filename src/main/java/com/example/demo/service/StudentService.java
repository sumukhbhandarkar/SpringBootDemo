package com.example.demo.service;

import com.example.demo.model.StudentModel;
import com.example.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;

    public void addStudent(StudentModel student) {
        repo.save(student);
    }

    public List<StudentModel> getAllStudents() {
        return repo.findAll();
    }

    public StudentModel searchStudent(String usn) {
        if (repo.findById(usn).isPresent())
            return repo.findById(usn).get();
        return new StudentModel();
//        return repo.getReferenceById(usn);
    }

    public void addManyStudents(List<StudentModel> studentModels) {
        repo.saveAll(studentModels);
    }
}
