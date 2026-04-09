package com.klu.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klu.model.Student;
import com.klu.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;
    public Student saveStudent(Student student) {
        return repository.save(student);
    }
    public List<Student> getAllStudents() {
        return repository.findAll();
    }
    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }
    public Student updateStudent(Long id, Student student) {
        student.setId(id);
        return repository.save(student);
    }
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}