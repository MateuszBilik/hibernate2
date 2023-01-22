package com.example.University.exercise;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SeederDB {

    private StudentRepository studentRepository;
    private UniversityRepository universityRepository;

    public SeederDB(StudentRepository studentRepository, UniversityRepository universityRepository) {
        this.studentRepository = studentRepository;
        this.universityRepository = universityRepository;
    }

    @Bean
    CommandLineRunner createRecords() {
        return args -> {
        University university = new University(null, "3 Maja", "Krakow", 1000L, "30-333", "Poland", null);
        Student student = new Student(null, "Mateusz", "+32 323 3232 232", "test@test.com", null);
        Student studentKarol = new Student(null, "Karol", "+32 444 444 444", "kolo@test.com", null);

        student.setUniversity(university);
        studentKarol.setUniversity(university);

        studentRepository.saveAll(List.of(student, studentKarol));
        };
    }
}
