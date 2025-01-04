package com.example.finalyear.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.finalyear.dto.StudentMarkDto;
import com.example.finalyear.entity.StudentMarks;
import com.example.finalyear.service.StudentMarksService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sms/mark")
public class StudentMarksController {

    private final StudentMarksService studentMarksService;

    @Autowired
    public StudentMarksController(StudentMarksService studentMarksService) {
        this.studentMarksService = studentMarksService;
    }

    @GetMapping
    public List<StudentMarks> getAllMarks() {
        return studentMarksService.getAllMarks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentMarks> getMarksById(@PathVariable Long id) {
        Optional<StudentMarks> studentMarks = studentMarksService.getMarksById(id);
        return studentMarks.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add-or-update")
    public List<StudentMarks> addOrUpdateMarks(@RequestBody List<StudentMarkDto> studentMarks) {
        return studentMarksService.saveOrUpdateMarks(studentMarks);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarks(@PathVariable Long id) {
        studentMarksService.deleteMarks(id);
        return ResponseEntity.noContent().build();
    }

    
}
