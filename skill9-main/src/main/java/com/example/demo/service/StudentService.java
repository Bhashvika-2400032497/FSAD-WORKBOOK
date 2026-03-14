package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.exception.StudentNotFoundException;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student getStudent(Long id) {

        Optional<Student> student = repository.findById(id);

        if(student.isPresent()) {
            return student.get();
        }

        throw new StudentNotFoundException("Student with ID " + id + " not found");

    }

}