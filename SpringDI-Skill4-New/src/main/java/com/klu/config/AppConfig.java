package com.klu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.klu.model.Student;

@Configuration
public class AppConfig {

    @Bean
    public Student student() {
        Student s = new Student(102, "Bhashvika", "B.Tech", 2);
        s.setCourse("B.Tech CSE");
        s.setYear(2);
        return s;
    }
}
