package com.example.University.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByNameAndEmailAddressAndUniversity_Country(String name, String emailAddress, String country);

    @Query("select s from Student s where s.name = ?1 or s.phoneNumber = ?2 or s.emailAddress = ?3")
    List<Student> findUserWhenOneMatch(String name, String phoneNumber, String emailAddress);

    @Query("select s from Student s where s.phoneNumber = ?1")
    List<Student> find(String phoneNumber);

    @Query("select s from Student s where s.emailAddress = ?1")
    List<Student> findByEmailAddress(String emailAddress);


}