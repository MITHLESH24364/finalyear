package com.example.finalyear.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "departments")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String departmentId;

    @Column(nullable = false)
    private String departmentName;

    @Column(nullable = false)
    private String headOfDepartment;

    @Column(nullable = false)
    private LocalDate startDate;
}
