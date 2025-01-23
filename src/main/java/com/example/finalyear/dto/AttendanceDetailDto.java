package com.example.finalyear.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDetailDto {
    private String sid;
    private Date date;
    private String absent;
    private String fullname;
    private String rollNo;
    private String studentClass;
    private String section;
}