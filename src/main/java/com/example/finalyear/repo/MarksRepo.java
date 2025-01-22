// package com.example.finalyear.repo;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
// import org.springframework.stereotype.Repository;

// import com.example.finalyear.entity.Marks;

// @Repository
// public interface MarksRepo extends JpaRepository<Marks,Long> {
//       @Query("SELECT m FROM Marks m WHERE m.studentId = :studentId AND m.year = :year AND m.term = :term")
//     Marks findByStudentIdAndYearAndTerm(@Param("studentId") int studentId, @Param("year") int year, @Param("term") String term);

// }


