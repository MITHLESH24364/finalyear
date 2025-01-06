package com.example.finalyear.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.finalyear.entity.Attendance;
 
@Repository
public interface AttendenceRepo extends JpaRepository<Attendance, Long> {

    List<Attendance> findByDate(Date date);

     @Query("SELECT a FROM Attendance a WHERE a.date = :date AND a.sid = :sid")
    List<Attendance> findByDateAndSid(Date date, String sid);

}
