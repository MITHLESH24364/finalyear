package com.example.finalyear.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name = "exam") 
public class Exam { 

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 

    @Column(name = "sid", nullable = false) 
    private String sid; 

    @Column(name = "year", nullable = false)
    private int year; 

    @Column(name = "term", nullable = false)
    private String term; 

} 
