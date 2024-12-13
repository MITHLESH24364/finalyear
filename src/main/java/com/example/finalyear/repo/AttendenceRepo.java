package com.example.finalyear.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalyear.entity.Attendance;

@Repository
public interface AttendenceRepo extends JpaRepository<Attendance, Long> {
    
}
