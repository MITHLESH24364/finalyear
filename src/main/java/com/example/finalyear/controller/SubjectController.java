package com.example.finalyear.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.finalyear.dto.SubjectDTO;
import com.example.finalyear.entity.Subject;
import com.example.finalyear.service.SubjectService;


@RestController
@RequestMapping("/sms/subjects")
public class SubjectController {
 
    @Autowired
    private SubjectService subjectService;

    @PostMapping("/add")
    public ResponseEntity<Subject> addSubject(@RequestBody SubjectDTO subjectDTO) {
        Subject savedSubject = subjectService.saveSubject(subjectDTO);
        return ResponseEntity.ok(savedSubject);
    }
@GetMapping("/{id}")
public ResponseEntity<Subject> getSubjectById(@PathVariable Long id) {
    return new ResponseEntity<Subject>(subjectService.getSubjectById(id), HttpStatus.OK);
           
}

@PutMapping("/update/{id}")
public ResponseEntity<String> updateSubject(@PathVariable Long id, @RequestBody SubjectDTO subjectDTO) {
   try {
       subjectService.updateSubject(id, subjectDTO);
       return ResponseEntity.ok("Subject updated successfully!");
   } catch (IllegalArgumentException e) {
       return ResponseEntity.badRequest().body(e.getMessage());
   } catch (Exception e) {
       return ResponseEntity.internalServerError().body("Failed to update Subject.");
   }
}






public String getMethodName(@RequestParam String param) {
    return new String();
}




    @GetMapping("/all")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> subjects = subjectService.getAllSubjects();
        return ResponseEntity.ok(subjects);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable Long id) {
        try {
            subjectService.deleteSubject(id);
            return ResponseEntity.ok("Subject deleted successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to delete Subject.");
        }
    }
}
