package com.example.finalyear.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.finalyear.dto.DepartmentDTO;
import com.example.finalyear.entity.Department;
import com.example.finalyear.service.DepartmentService;

@RestController
@RequestMapping("/sms/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<String> addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        try {
            departmentService.addDepartment(departmentDTO);
            return ResponseEntity.ok("Department added successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   
    @GetMapping("/all")
    public ResponseEntity<List<Department>> getAllStaff() {
        List<Department> departmentList = departmentService.getAllDepartment();
        return ResponseEntity.ok(departmentList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDTO departmentDTO) {
    try {
        departmentService.updateDepartment(id, departmentDTO);
        return ResponseEntity.ok("Department updated successfully!");
    } catch (IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.internalServerError().body("Failed to update department.");
    }
}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        try {
            departmentService.deleteDepartment(id);
            return ResponseEntity.ok("Department deleted successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to delete department.");
        }
    }
}

    


