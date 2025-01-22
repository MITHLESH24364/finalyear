package com.example.finalyear.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.finalyear.entity.StudentMarks;
import com.example.finalyear.entity.StudentsDetail;
 
@Repository
public interface StudentMarksRepository extends JpaRepository<StudentMarks, Long> {
    // Custom query methods if needed
    // Optional<StudentMarks> findByStudentAndTermAndYearAndSubject(
    // StudentsDetail student, String term, String year, String subject);
    @Query("SELECT m FROM StudentMarks m WHERE m.term = :term AND m.year = :year AND m.subject = :subject")
    List<StudentMarks> findByFilters(
            @Param("term") String term,
            @Param("year") String year,
            @Param("subject") String subject);

    Optional<StudentMarks> findByStudentAndTermAndYearAndSubject(
            StudentsDetail student,
            String term,
            String year,
            String subject);
}
