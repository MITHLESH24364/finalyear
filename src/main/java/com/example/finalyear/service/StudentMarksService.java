package com.example.finalyear.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalyear.dto.StudentMarkDto;
import com.example.finalyear.entity.Marks;
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

    public static List<StudentMarks> getMarksByFilters(String classLevel, String section, String term, String year, String subject) {
    return StudentMarksRepository.findByFilters(classLevel, section, term, year, subject);
}


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

        // Check if a record with matching fields exists
        Optional<StudentMarks> existingMarks = studentMarksRepository.findByStudentAndTermAndYearAndSubject(
                student, studentMarkDto.getTerm(), studentMarkDto.getYear(), studentMarkDto.getSubject());

        StudentMarks studentMarks;
        if (existingMarks.isPresent()) {
            // Update existing record
            studentMarks = existingMarks.get();
            studentMarks.setMarks(studentMarkDto.getMarks());
        } else {
            // Create new record
            studentMarks = new StudentMarks();
            studentMarks.setStudent(student);
            studentMarks.setTerm(studentMarkDto.getTerm());
            studentMarks.setYear(studentMarkDto.getYear());
            studentMarks.setSubject(studentMarkDto.getSubject());
            studentMarks.setMarks(studentMarkDto.getMarks());
        }

        // Save and collect saved entity
        savedStudentMarks.add(studentMarksRepository.save(studentMarks));
    }

    return savedStudentMarks;
}



    public void deleteMarks(Long id) {
        studentMarksRepository.deleteById(id);
    }
}
