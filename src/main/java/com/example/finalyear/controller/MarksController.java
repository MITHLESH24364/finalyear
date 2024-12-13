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

import com.example.finalyear.entity.Marks;
import com.example.finalyear.service.MarkService;

@RestController
@RequestMapping("/sms/marks/")
public class MarksController {
    @Autowired
    private MarkService marksService;

    // Add new marks
    @PostMapping("/add")
    public ResponseEntity<Marks> addMarks(@RequestBody Marks marks) {
        Marks addedMarks = marksService.addMarks(marks);
        return ResponseEntity.ok(addedMarks);
    }

    // Update marks
    @PutMapping("/update")
    public ResponseEntity<Marks> updateMarks(@RequestBody Marks marks) {
        Marks updatedMarks = marksService.updateMarks(marks);
        return ResponseEntity.ok(updatedMarks);
    }

    // Delete marks by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMarks(@PathVariable("id") long id) {
        boolean isDeleted = marksService.deleteMarks(id);
        if (isDeleted) {
            return ResponseEntity.ok("Marks record deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Marks record not found.");
        }
    }

    // Get marks by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Marks> getMarksById(@PathVariable("id") long id) {
        Marks marks = marksService.getMarksById(id);
        if (marks != null) {
            return ResponseEntity.ok(marks);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Get all marks records
    @GetMapping("/all")
    public ResponseEntity<List<Marks>> getAllMarks() {
        List<Marks> marksList = marksService.getAllMarks();
        return ResponseEntity.ok(marksList);
    }
}
