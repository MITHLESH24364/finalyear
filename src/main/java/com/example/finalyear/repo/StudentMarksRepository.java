package com.example.finalyear.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalyear.entity.StudentMarks;
import com.example.finalyear.entity.StudentsDetail;

@Repository
public interface StudentMarksRepository extends JpaRepository<StudentMarks, Long> {
    // Custom query methods if needed
    Optional<StudentMarks> findByStudentAndTermAndYearAndSubject(
    StudentsDetail student, String term, String year, String subject);

    

}
