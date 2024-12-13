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

import com.example.finalyear.entity.Staff;
import com.example.finalyear.entity.StudentsDetail;
import com.example.finalyear.service.StaffService;
import com.example.finalyear.service.StudentService;

@RestController
@RequestMapping("/sms/user/")
public class UserController {
    @Autowired
    private StaffService staffService;

    @Autowired
    private StudentService studentService;

    // Add a new staff
    @PostMapping("/staff/add")
    public ResponseEntity<Staff> addStaff(@RequestBody Staff staff) {
        Staff addedStaff = staffService.addStaff(staff);
        return ResponseEntity.ok(addedStaff);
    }

    // Update an existing staff
    @PutMapping("/staff/update")
    public ResponseEntity<Staff> updateStaff(@RequestBody Staff staff) {
        Staff updatedStaff = staffService.updateStaff(staff);
        return ResponseEntity.ok(updatedStaff);
    }

    // Delete a staff by ID
    @DeleteMapping("/staff/delete/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable("id") long id) {
        boolean isDeleted = staffService.deleteStaff(id);
        if (isDeleted) {
            return ResponseEntity.ok("Staff deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Staff not found.");
        }
    }

    // Get a staff by ID
    @GetMapping("/staff/get/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable("id") long id) {
        Staff staff = staffService.getStaffById(id);
        if (staff != null) {
            return ResponseEntity.ok(staff);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Get all staff
    @GetMapping("/staff/all")
    public ResponseEntity<List<Staff>> getAllStaff() {
        List<Staff> staffList = staffService.getAllStaff();
        return ResponseEntity.ok(staffList);
    }

    // Add a new student
    @PostMapping("/student/add")
    public ResponseEntity<StudentsDetail> addStudent(@RequestBody StudentsDetail student) {
        StudentsDetail addedStudent = studentService.addStudentsDetail(student);
        return ResponseEntity.ok(addedStudent);
    }

    // Update an existing student
    @PutMapping("/student/update")
    public ResponseEntity<StudentsDetail> updateStudent(@RequestBody StudentsDetail student) {
        StudentsDetail updatedStudent = studentService.updateStudentsDetail(student);
        return ResponseEntity.ok(updatedStudent);
    }

    // Delete a student by ID
    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
        boolean isDeleted = studentService.deleteStudentsDetail(id);
        if (isDeleted) {
            return ResponseEntity.ok("Student deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Student not found.");
        }
    }

    // Get a student by ID
    @GetMapping("/student/get/{id}")
    public ResponseEntity<StudentsDetail> getStudentById(@PathVariable("id") long id) {
        StudentsDetail student = studentService.getStudentsDetailById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Get all students
    @GetMapping("/student/all")
    public ResponseEntity<List<StudentsDetail>> getAllStudents() {
        List<StudentsDetail> studentList = studentService.getAllStudentsDetail();
        return ResponseEntity.ok(studentList);
    }
}
