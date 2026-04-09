package com.klu.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.klu.model.Student;
import com.klu.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;
    @Operation(summary = "Add new student")
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }
    @Operation(summary = "Get all students")
    @GetMapping
    public List<Student> getStudents() {
        return service.getAllStudents();
    }
    @Operation(summary = "Get student by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {

        return service.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @Operation(summary = "Update student")
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @RequestBody Student student) {
        return service.updateStudent(id, student);
    }
    @Operation(summary = "Delete student")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {

        service.deleteStudent(id);
        return ResponseEntity.ok().build();
    }
}