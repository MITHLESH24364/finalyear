package com.example.finalyear.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalyear.entity.Exam;
import com.example.finalyear.service.ExamService;

@RestController
@RequestMapping("/sms/exam/")
public class ExamsController {
    @Autowired
    private ExamService examService;

    // Add a new exam
    @PostMapping("/add")
    public ResponseEntity<Exam> addExam(@RequestBody Exam exam) {
        Exam addedExam = examService.addExam(exam);
        return ResponseEntity.ok(addedExam);
    }

    // Update an existing exam
    @PutMapping("/update")
    public ResponseEntity<Exam> updateExam(@RequestBody Exam exam) {
        Exam updatedExam = examService.updateExam(exam);
        return ResponseEntity.ok(updatedExam);
    }

    // Delete an exam by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExam(@PathVariable("id") long id) {
        boolean isDeleted = examService.deleteExam(id);
        if (isDeleted) {
            return ResponseEntity.ok("Exam deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Exam not found.");
        }
    }

    // Get an exam by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable("id") long id) {
        Exam exam = examService.getExamById(id);
        if (exam != null) {
            return ResponseEntity.ok(exam);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Get all exams
    @GetMapping("/all")
    public ResponseEntity<List<Exam>> getAllExams() {
        List<Exam> exams = examService.getAllExam();
        return ResponseEntity.ok(exams);
    }
}
