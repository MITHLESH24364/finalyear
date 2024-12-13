package com.example.finalyear.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalyear.entity.Marks;

@Repository
public interface MarksRepo extends JpaRepository<Marks,Long> {
    
}
