package com.klu.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.klu.model.Course;

@Service
public class CourseService {

    private List<Course> courses = new ArrayList<>();

    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourseById(int id) {
        for (Course c : courses) {
            if (c.getCourseId() == id) {
                return c;
            }
        }
        return null;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public boolean updateCourse(int id, Course newCourse) {
        for (Course c : courses) {
            if (c.getCourseId() == id) {
                c.setTitle(newCourse.getTitle());
                c.setDuration(newCourse.getDuration());
                c.setFee(newCourse.getFee());
                return true;
            }
        }
        return false;
    }

    public boolean deleteCourse(int id) {
        return courses.removeIf(c -> c.getCourseId() == id);
    }

    public List<Course> searchByTitle(String title) {
        List<Course> result = new ArrayList<>();

        for (Course c : courses) {
            if (c.getTitle().equalsIgnoreCase(title)) {
                result.add(c);
            }
        }

        return result;
    }
}