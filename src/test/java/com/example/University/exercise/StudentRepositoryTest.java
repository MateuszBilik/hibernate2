package com.example.University.exercise;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private UniversityRepository universityRepository;

    @BeforeAll
    void seedDB(){
        University university = new University(null, "3 Maja", "Krakow", 1000L, "30-333", "Poland", null);
        Student student = new Student(null, "Mateusz", "+32 323 3232 232", "test@test.com", null);
        Student studentKarol = new Student(null, "Karol", "+32 444 444 444", "kolo@test.com", null);

        student.setUniversity(university);
        studentKarol.setUniversity(university);

        studentRepository.saveAll(List.of(student, studentKarol));
    }

    @Test
    void findByNameAndEmailAddressAndUniversity_Country() {
        //given

        //when
        var student =  studentRepository.findByNameAndEmailAddressAndUniversity_Country("Mateusz", "test@test.com", "Poland");
        //then
        assertEquals("Mateusz", student.isPresent());
    }

    @Test
    void findUserWhenOneMatch() {
        fail();
    }

    @Test
    void find() {
        fail();
    }

    @Test
    void findByEmailAddress() {
        fail();
    }
}