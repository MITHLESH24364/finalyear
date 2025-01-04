package com.example.finalyear.dto;

import lombok.Data;

@Data
public class StudentMarkDto {
    private Long id;
    private Long student;
    private String term;
    private String year;
    private String subject;
    private Double marks;
}
