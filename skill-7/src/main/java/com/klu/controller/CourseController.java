package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Course;
import com.klu.Service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    // Add Course
    @PostMapping
    public ResponseEntity<String> addCourse(@RequestBody Course course) {
        service.addCourse(course);
        return new ResponseEntity<>("Course Added Successfully", HttpStatus.CREATED);
    }

    // Get All Courses
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    // Get Course by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id) {

        Course course = service.getCourseById(id);

        if (course == null) {
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    // Update Course
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable int id, @RequestBody Course course) {

        boolean updated = service.updateCourse(id, course);

        if (!updated) {
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Course Updated Successfully", HttpStatus.OK);
    }

    // Delete Course
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {

        boolean deleted = service.deleteCourse(id);

        if (!deleted) {
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Course Deleted Successfully", HttpStatus.OK);
    }

    // Search by Title
    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchCourse(@PathVariable String title) {

        List<Course> result = service.searchByTitle(title);

        if (result.isEmpty()) {
            return new ResponseEntity<>("No Courses Found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}