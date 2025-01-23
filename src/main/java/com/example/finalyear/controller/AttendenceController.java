package com.example.finalyear.controller;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.finalyear.dto.AttendanceDetailDto;
import com.example.finalyear.entity.Attendance;
import com.example.finalyear.service.AttendenceService;

@RestController
@RequestMapping("/sms/attandence/")
public class AttendenceController {
    @Autowired
    private AttendenceService attendenceService;

    // Add a new attendance record
    @PostMapping("/add")
    public ResponseEntity<Attendance> addAttendance(@RequestBody Attendance attendance) {
        Attendance addedAttendance = attendenceService.addAttendance(attendance);
        return ResponseEntity.ok(addedAttendance);
    }

    // Update an existing attendance record
    @PutMapping("/update")
    public ResponseEntity<Attendance> updateAttendance(@RequestBody Attendance attendance) {
        Attendance updatedAttendance = attendenceService.updateAttendance(attendance);
        return ResponseEntity.ok(updatedAttendance);
    }

    // Delete an attendance record by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAttendance(@PathVariable("id") long id) {
        boolean isDeleted = attendenceService.deleteAttendance(id);
        if (isDeleted) {
            return ResponseEntity.ok("Attendance record deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Attendance record not found.");
        }
    }

    // Get an attendance record by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable("id") long id) {
        Attendance attendance = attendenceService.getAttendanceById(id);
        if (attendance != null) {
            return ResponseEntity.ok(attendance);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    // Get all attendance records
    @GetMapping("/all")
    public ResponseEntity<List<Attendance>> getAllAttendance() {
        List<Attendance> attendances = attendenceService.getAllAttendance();
        return ResponseEntity.ok(attendances);
    }


    @PostMapping("/bulk-add")
public ResponseEntity<List<Attendance>> addBulkAttendance(@RequestBody List<Attendance> attendances) {
    List<Attendance> addedAttendances = attendenceService.addBulkAttendance(attendances);
    return ResponseEntity.ok(addedAttendances);
}


@GetMapping("/getByDate")
public ResponseEntity<List<Attendance>> getAttendanceByDate(
        @RequestParam("date") String date,
        @RequestParam("class") String studentClass,
        @RequestParam("section") String section) {
    List<Attendance> attendanceRecords = attendenceService.getAttendanceByDate(date, studentClass, section);
    return ResponseEntity.ok(attendanceRecords);
}


@GetMapping("/absent/getByDate")
public ResponseEntity<List<AttendanceDetailDto>> getAbsentStudentDetails(
        @RequestParam("date") String date,
        @RequestParam("class") String studentClass,
        @RequestParam("section") String section) {
    List<AttendanceDetailDto> absentStudents = 
        attendenceService.getAbsentStudentDetails(date, studentClass, section);
    return ResponseEntity.ok(absentStudents);
}


@GetMapping("/sid/{sid}")
    public List<Attendance> getAttendanceBySid(@PathVariable String sid) {
        return attendenceService.getAttendanceBySid(sid);
    }

    @GetMapping("/date")
    public List<Attendance> getAttendanceByDate(@RequestParam Date date) {
        String dateString = date.toString();
        return attendenceService.getAttendanceByDate(dateString);
    }
    


}



