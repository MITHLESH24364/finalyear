package com.example.finalyear.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalyear.entity.Exam;

@Repository
public interface ExamsRepo extends JpaRepository<Exam, Long> {

}
