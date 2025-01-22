// package com.example.finalyear.entity;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @Entity
// @Table(name = "marks")
// public class Marks {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private long id;

//     @Column(name = "student_id", nullable = false)
//     private int studentId; // Foreign key to reference student information

//     @Column(name = "year", nullable = false)
//     private int year; // Year of the examination

//     @Column(name = "term", nullable = false)
//     private String term; // Term of the examination (e.g., First, Second, Final)

//     @Column(name = "english")
//     private Float english; // Marks for English

//     @Column(name = "nepali")
//     private Float nepali; // Marks for Nepali

//     @Column(name = "math")
//     private Float math; // Marks for Mathematics

//     @Column(name = "science")
//     private Float science; // Marks for Science

//     @Column(name = "social")
//     private Float social; // Marks for Social Studies

//     @Column(name = "opt_math")
//     private Float optMath; // Marks for Optional Mathematics

//     @Column(name = "opt_english")
//     private Float optEnglish; // Marks for Optional English

//     @Column(name = "opt_computer")
//     private Float optComputer;

//     @Column(name = "opt_accountancy")
//     private Float optAccountancy;

//     @Column(name = "opt_science")
//     private Float optScience;

// }
