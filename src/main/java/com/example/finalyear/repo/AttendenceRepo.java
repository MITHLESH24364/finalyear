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


    List<Attendance> findByDate(Date date);
    
}
