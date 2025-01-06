package com.example.finalyear.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class DepartmentDTO {
    private String departmentId;
    private String departmentName;
    private String headOfDepartment;
    private LocalDate startDate;
}
