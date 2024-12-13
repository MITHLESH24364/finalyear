package com.example.finalyear.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity 
@Table(name = "login") 
public class Login { 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
   private long id; 

     @Column(name = "user_id", nullable = false) 
    private String userId; 

    @Column(name = "username", nullable = false) 
    private String username; 

    @Column(name = "password", nullable = false) 
    private String password; 

    @Column(name = "role", nullable = false) 
    private String role; 

    @OneToOne(optional = true)
    private StudentsDetail student;

    @OneToOne(optional = true)
    private Staff staff;
}