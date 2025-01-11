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
import org.yaml.snakeyaml.error.Mark;

import com.example.finalyear.entity.Attendance;
import com.example.finalyear.entity.Marks;
import com.example.finalyear.entity.StudentMarks;
import com.example.finalyear.service.MarkService;
import com.example.finalyear.service.StudentMarksService;

@RestController
@RequestMapping("/sms/marks/")
public class MarksController {
    @Autowired
    private MarkService marksService;



    // Add or Update Marks
        @PostMapping("/add-or-update")
        public ResponseEntity<Marks> addOrUpdateMarks(@RequestBody Marks marks) {
            Marks result = marksService.addOrUpdateMarks(marks);
            return ResponseEntity.ok(result);
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

    @PostMapping("/bulk-add")
    public ResponseEntity<List<Marks>> addBulkMarks(@RequestBody List<Marks> marks) {
    List<Marks> addedMarks = marksService.addBulkMarks(marks);
    return ResponseEntity.ok(addedMarks);
}

@GetMapping("/get/{classLevel}/{section}/{term}/{year}/{subject}")
public ResponseEntity<List<StudentMarks>> getMarksByFilters(
    @PathVariable("classLevel") String classLevel,
    @PathVariable("section") String section,
    @PathVariable("term") String term,
    @PathVariable("year") String year,
    @PathVariable("subject") String subject) {
    List<StudentMarks> marksList = StudentMarksService.getMarksByFilters(classLevel, section, term, year, subject);
    return ResponseEntity.ok(marksList);
}

}
