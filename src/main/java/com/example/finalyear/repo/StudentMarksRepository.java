package com.example.finalyear.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalyear.entity.StudentMarks;

@Repository
public interface StudentMarksRepository extends JpaRepository<StudentMarks, Long> {
    // Custom query methods if needed
}
