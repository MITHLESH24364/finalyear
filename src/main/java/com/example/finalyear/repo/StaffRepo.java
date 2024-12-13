package com.example.finalyear.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalyear.entity.Staff;

@Repository
public interface StaffRepo extends JpaRepository<Staff, Long>{
    
}
