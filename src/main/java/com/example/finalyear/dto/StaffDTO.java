package com.example.finalyear.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDTO {

    private Long id;
    private String staffId;
    private String fullname;
    private String gender; // Expecting "MALE", "FEMALE", "OTHER"
    private String dateOfBirth; // Format: YYYY-MM-DD
    private String email;
    private String phoneNumber;
    private String location;
    private String bloodGroup; // Expecting "A_PLUS", "B_MINUS", etc.
    private String department;
    private String classTeacher;
    private String blockHead;
    private String username;
    private String password;
    private String teacherPhoto;
}