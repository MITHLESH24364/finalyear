package com.example.finalyear.controller;

import com.example.finalyear.dto.SectionDTO;
import com.example.finalyear.entity.SectionEntity;
import com.example.finalyear.service.SectionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/sms/sections")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @PostMapping("/add")
    public ResponseEntity<?> addSection(@RequestBody SectionDTO sectionDTO) {
        try {
            SectionEntity sectionEntity = sectionService.addSection(sectionDTO);
            return new ResponseEntity<>(sectionEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add section. Please try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllSections() {
      List<SectionEntity> sections = sectionService.getAllSections();
        return  ResponseEntity.ok(sections);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSectionById(@PathVariable Long id) {
      return ResponseEntity.ok(sectionService.getSectionById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSection(@PathVariable Long id, @RequestBody SectionDTO sectionDTO) {
        try {
            sectionService.updateSection(id, sectionDTO);
            return ResponseEntity.ok("Section updated successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to update Section.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSection(@PathVariable Long id) {
        try {
            sectionService.deleteSection(id);
            return ResponseEntity.ok("Section deleted successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to delete Section.");
        }
    }

    @GetMapping("/byClassId")
    public ResponseEntity<?> getSectionsByClassId(@RequestParam Long classId) {
        return ResponseEntity.ok(sectionService.getSectionsByClassId(classId));
    }

    

    // You can add more methods like getSectionById, deleteSection, etc.
}
 