package com.example.University.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UniversityRepository extends JpaRepository<University, Long> {
    @Query("select u from University u where u.fee < ?1")
    List<University> findUniversitiesCheaperThan(Long fee);
    @Query("select u from University u where u.fee is null")
    List<University> findUniversityWithoutFee();

    Optional<University> findByStreetAndCityAndPostalCodeAndCountry(String street, String city, String postalCode, String country);


}