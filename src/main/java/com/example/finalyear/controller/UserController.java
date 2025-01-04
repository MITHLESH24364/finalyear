package com.example.finalyear.controller;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.finalyear.dto.StaffDTO;
import com.example.finalyear.entity.Staff;
import com.example.finalyear.entity.StudentsDetail;
import com.example.finalyear.repo.StudentRepo;
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
    public ResponseEntity<Staff> addStaff(@RequestBody StaffDTO staff) {
        Staff addedStaff = staffService.addStaff(staff);
        return ResponseEntity.ok(addedStaff);
    }

    // // Update an existing staff
    // @PutMapping("/staff/update")
    // public ResponseEntity<Staff> updateStaff(@RequestBody StaffDTO staff) {
    //     Staff updatedStaff = staffService.updateStaff(staff);
    //     return ResponseEntity.ok(updatedStaff);
    // }



    // @PutMapping("/staff/update/{id}")
    // public ResponseEntity<Staff> updateStaff(@RequestBody Staff staff, @PathVariable("id") long id) {
    //     try {
    //         Staff updateStaff = StaffService.updateStaff(id, staff);
    //         return ResponseEntity.ok(updateStaff);
    //     } catch (RuntimeException e) {
    //         return ResponseEntity.status(404).body(null);
    //     }
    // }
    

    @PutMapping("/staff/update/{id}")
public ResponseEntity<Staff> updateStaff(@RequestBody Staff staff, @PathVariable("id") long id) {
    try {
        Staff updatedStaff = staffService.updateStaff(id, staff);
        return ResponseEntity.ok(updatedStaff);
    } catch (RuntimeException e) {
        return ResponseEntity.status(404).body(null);
    }
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

    // // Update an existing student
    // @PutMapping("/student/update/{id}")
    // public ResponseEntity<StudentsDetail> updateStudent(@RequestBody StudentsDetail student, @PathVariable("id") long id) {
    //     StudentsDetail updatedStudent = studentService.updateStudentsDetail(student);
    //     // return ResponseEntity.ok(updatedStudent);
    //     if (updatedStudent != null) {
    //         return ResponseEntity.ok(updatedStudent);
    //     } else {
    //         return ResponseEntity.status(404).body(null);
    //     }
    // }

    @PutMapping("/student/update/{id}")
    public ResponseEntity<StudentsDetail> updateStudent(@RequestBody StudentsDetail student, @PathVariable("id") long id) {
        try {
            StudentsDetail updatedStudent = studentService.updateStudentsDetail(id, student);
            return ResponseEntity.ok(updatedStudent);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }
    




// @PutMapping("/student/update/{id}")
// public ResponseEntity<?> updateStudent(
//         @PathVariable Long id,
//         @ModelAttribute StudentsDetail studentsDetail) {
//     try {
//         // Handle image processing
//         if (!studentPhoto.isEmpty()) {
//             String fileName = studentPhoto.getOriginalFilename();
//             String filePath = "uploads/" + fileName; // Adjust path as needed
//             Files.copy(studentPhoto.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
//             studentsDetail.setImage(filePath);
//         }

        // Update logic
//         studentsDetail.setAccountId(id);
//         StudentsDetail updatedStudent = studentService.updateStudentsDetail(studentsDetail);
//         return ResponseEntity.ok(updatedStudent);

//     } catch (Exception e) {
//         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating student.");
//     }
// }



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
