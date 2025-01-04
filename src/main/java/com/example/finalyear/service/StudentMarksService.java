package com.example.finalyear.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalyear.dto.StudentMarkDto;
import com.example.finalyear.entity.StudentMarks;
import com.example.finalyear.entity.StudentsDetail;
import com.example.finalyear.repo.StudentMarksRepository;
import com.example.finalyear.repo.StudentRepo;

import jakarta.persistence.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentMarksService {

    private final StudentMarksRepository studentMarksRepository;

    @Autowired
    public StudentRepo studentRepo;

    public StudentMarksService(StudentMarksRepository studentMarksRepository) {
        this.studentMarksRepository = studentMarksRepository;
    }

    public List<StudentMarks> getAllMarks() {
        return studentMarksRepository.findAll();
    }

    public Optional<StudentMarks> getMarksById(Long id) {
        return studentMarksRepository.findById(id);
    }

    // public StudentMarks saveOrUpdateMarks(List<StudentMarkDto> studentMarks) {
    //     // Validate input
    //     if (studentMarks.getTerm() == null || studentMarks.getYear() == null ||
    //             studentMarks.getSubject() == null || studentMarks.getMarks() == null) {
    //         throw new IllegalArgumentException("All fields are required.");
    //     }

    //     // Fetch student details
    //     StudentsDetail student = studentRepo.findById(studentMarks.getStudent())
    //             .orElseThrow(
    //                     () -> new EntityNotFoundException("Student not found with ID: " + studentMarks.getStudent()));

    //     // Map DTO to entity
    //     StudentMarks studentMarks2 = new StudentMarks();
    //     studentMarks2.setStudent(student);
    //     studentMarks2.setTerm(studentMarks.getTerm());
    //     studentMarks2.setYear(studentMarks.getYear());
    //     studentMarks2.setSubject(studentMarks.getSubject());
    //     studentMarks2.setMarks(studentMarks.getMarks());

    //     // Save and return
    //     return studentMarksRepository.save(studentMarks2);
    // }

public List<StudentMarks> saveOrUpdateMarks(List<StudentMarkDto> studentMarkDtos) {
    // Validate input
    if (studentMarkDtos == null || studentMarkDtos.isEmpty()) {
        throw new IllegalArgumentException("Student mark data list cannot be null or empty.");
    }

    List<StudentMarks> savedStudentMarks = new ArrayList<>();

    for (StudentMarkDto studentMarkDto : studentMarkDtos) {
        // Validate each DTO
        if (studentMarkDto.getTerm() == null || studentMarkDto.getYear() == null ||
                studentMarkDto.getSubject() == null || studentMarkDto.getMarks() == null ||
                studentMarkDto.getStudent() == null) {
            throw new IllegalArgumentException("All fields in StudentMarkDto are required.");
        }

        // Fetch student details
        StudentsDetail student = studentRepo.findById(studentMarkDto.getStudent())
                .orElseThrow(
                        () -> new EntityNotFoundException("Student not found with ID: " + studentMarkDto.getStudent()));

        // Map DTO to entity
        StudentMarks studentMarks = new StudentMarks();
        studentMarks.setStudent(student);
        studentMarks.setTerm(studentMarkDto.getTerm());
        studentMarks.setYear(studentMarkDto.getYear());
        studentMarks.setSubject(studentMarkDto.getSubject());
        studentMarks.setMarks(studentMarkDto.getMarks());

        // Save and collect saved entity
        savedStudentMarks.add(studentMarksRepository.save(studentMarks));
    }

    return savedStudentMarks;
}




    public void deleteMarks(Long id) {
        studentMarksRepository.deleteById(id);
    }
}