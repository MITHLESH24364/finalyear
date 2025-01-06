package com.example.finalyear.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.finalyear.dto.DepartmentDTO;
import com.example.finalyear.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    boolean existsByDepartmentId(String departmentId);
}

