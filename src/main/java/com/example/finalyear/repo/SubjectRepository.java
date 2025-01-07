package com.example.finalyear.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.finalyear.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
