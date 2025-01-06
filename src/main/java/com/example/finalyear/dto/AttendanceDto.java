package com.example.finalyear.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class AttendanceDto {
    private Long id;
    private String sid;
    private Data date;
    private String present;
    private String late;
    private String absent;

}
