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


    @Query("SELECT m FROM StudentMarks m WHERE m.student.studentClass = :classLevel AND m.student.section = :section AND m.term = :term AND m.year = :year AND m.subject = :subject")
    static
List<StudentMarks> findByFilters(
    @Param("classLevel") String classLevel,
    @Param("section") String section,
    @Param("term") String term,
    @Param("year") String year,
    @Param("subject") String subject) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByFilters'");
    }

    Optional<StudentMarks> findByStudentAndTermAndYearAndSubject(StudentsDetail student, String term, String year,
            String subject);

    

}
