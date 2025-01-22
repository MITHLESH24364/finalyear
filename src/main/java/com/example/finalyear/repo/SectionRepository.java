package com.example.finalyear.repo;


import com.example.finalyear.entity.SectionEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<SectionEntity, Long> {
    // You can add custom query methods if necessary

    List<SectionEntity> findByClassId(Long classId);  // Method to fetch sections by classId

}
