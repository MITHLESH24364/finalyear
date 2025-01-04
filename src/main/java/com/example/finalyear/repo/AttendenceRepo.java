package com.example.finalyear.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.finalyear.entity.Attendance;

@Repository
public interface AttendenceRepo extends JpaRepository<Attendance, Long> {
    
    // @Query("SELECT a FROM Attendance a WHERE a.date = :date AND a.sid IN " +
    //        "(SELECT s.accountId FROM Student s WHERE s.studentClass = :studentClass AND s.section = :section)")
    // List<Attendance> findByDateAndClassAndSection(
    //     @Param("date") Date date,
    //     @Param("studentClass") String studentClass,
    //     @Param("section") String section
    // );

    List<Attendance> findByDate(Date date);
    
}
