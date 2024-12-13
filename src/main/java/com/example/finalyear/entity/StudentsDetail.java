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
@Table(name = "students_detail")
public class StudentsDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_birth")
    private String dateOfBirth;

    @Column(name = "roll_no")
    private String rollNo;

    @Column(name = "location")
    private String location;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "religion")
    private String religion;

    @Column(name = "email")
    private String email;

    @Column(name = "student_class")
    private String studentClass;

    @Column(name = "section")
    private String section;

    @Column(name = "number")
    private String number;

    @Column(name = "parent_name")
    private String parentName;

    @Column(name = "parent_no")
    private String parentNo;

    @Column(name = "image")
    private String image;

}