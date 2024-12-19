package com.example.finalyear.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "staff") 
public class Staff { 

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private long id; 

    @Column(name = "Staff_id", nullable = false) 
    private String staffId; 

    @Column(name = "fullname", nullable = false) 
    private String fullname; 

    @Enumerated(EnumType.STRING) 
    @Column(name = "gender", nullable = false) 
    private Gender gender; 

    @Column(name = "date_of_birth", nullable = false) 
    private String dateOfBirth; 

    @Column(name = "email", nullable = false) 
    private String email; 

    @Column(name = "phone_number", nullable = false) 
    private String phoneNumber; 

    @Column(name = "Location") 
    private String location; 

    @Enumerated(EnumType.STRING) 
    @Column(name = "Blood_group") 
    private BloodGroup bloodGroup; 

    @Column(name = "department", nullable = false) 
    private String department; 

    @Column(name = "class_teacher") 
    private String classTeacher; 

    @Column(name = "block_head") 
    private String blockHead; 

    @Column(name = "image") 
    private String image; 

    public enum Gender { MALE, FEMALE, OTHER } 
    public enum BloodGroup { A_PLUS, A_MINUS, B_PLUS, B_MINUS, AB_PLUS, AB_MINUS, O_PLUS, O_MINUS } 

} 