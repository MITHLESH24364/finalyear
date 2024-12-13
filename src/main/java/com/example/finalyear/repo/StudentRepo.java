package com.example.finalyear.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalyear.entity.StudentsDetail;

@Repository
public interface StudentRepo extends JpaRepository<StudentsDetail, Long> {
    
}
