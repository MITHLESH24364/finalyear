package com.example.finalyear.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalyear.dto.AttendanceDetailDto;
import com.example.finalyear.entity.Attendance;
import com.example.finalyear.repo.AttendenceRepo;

@Service
public class AttendenceService {
    @Autowired
    AttendenceRepo attendanceRepo;

    public Attendance addAttendance(Attendance attendance) {
        return attendanceRepo.save(attendance);
    }

    public Attendance updateAttendance(Attendance attendance) {
        Attendance attendanceDetail = attendanceRepo.getById(attendance.getId());
        attendanceDetail = attendance;
        return attendanceRepo.save(attendanceDetail);
    }

    public boolean deleteAttendance(long userId) {
        Attendance attendanceDetail = attendanceRepo.getById(userId);
        if (attendanceDetail != null) {
            attendanceRepo.delete(attendanceDetail);
            return true;
        }
        return false;
    }

    public Attendance getAttendanceById(long attendanceId) {
        return attendanceRepo.findById(attendanceId).orElse(null);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepo.findAll();
    }

    // public List<Attendance> addBulkAttendance(List<Attendance> attendances) {
    //     return attendanceRepo.saveAll(attendances);
    // }
    public List<Attendance> addBulkAttendance(List<Attendance> attendances) {
        for (Attendance attendance : attendances) {
            // Check if an attendance record exists with the same date and sid
            List<Attendance> existingAttendances = attendanceRepo.findByDateAndSid(attendance.getDate(), attendance.getSid());
            if (!existingAttendances.isEmpty()) {
                // If found, update the existing record
                Attendance existingAttendance = existingAttendances.get(0);
                existingAttendance.setPresent(attendance.getPresent());
                existingAttendance.setLate(attendance.getLate());
                existingAttendance.setAbsent(attendance.getAbsent());
                attendanceRepo.save(existingAttendance);
            } else {
                // If not found, add a new record
                attendanceRepo.save(attendance);
            }
        }
        return attendanceRepo.findAll(); // Return updated list of attendances
    }
    

    public List<Attendance> getAttendanceByDate(String date, String studentClass, String section) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        // Parse the date string into a util.Date
        Date parsedDate;
        try {
            parsedDate = formatter.parse(date);
            return attendanceRepo.findByDate(parsedDate);

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
        // Use the parsedDate to query the repository
    }


    // public List<Attendance> getAttendanceByDate(Date date) {
    //     return attendanceRepo.findByDate(date);
    // }


//     public List<Attendance> getAttendanceByDate(String date) {
//     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

//     // Parse the date string into a util.Date
//     Date parsedDate;
//     try {
//         parsedDate = formatter.parse(date);
        
//         // Fetch all attendances for the given date, class, and section
//         List<Attendance> allAttendance = attendanceRepo.findByDate(parsedDate);
        
//         // Filter the list to return only those where 'absent' is 'a'
//         List<Attendance> absentAttendance = new ArrayList<>();
//         for (Attendance attendance : allAttendance) {
//             if ("a".equals(attendance.getAbsent())) {
//                 absentAttendance.add(attendance);
//             }
//         }
        
//         return absentAttendance;

//     } catch (ParseException e) {
//         e.printStackTrace();
//     }
//     return null;
// }

public List<Attendance> getAttendanceByDate(String date) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    try {
        Date parsedDate = formatter.parse(date);
        
        // Fetch all attendances for the given date
        List<Attendance> allAttendance = attendanceRepo.findByDate(parsedDate);
        
        // Filter the list to return only those where 'absent' is 'a'
        List<Attendance> absentAttendance = new ArrayList<>();
        for (Attendance attendance : allAttendance) {
            if ("a".equals(attendance.getAbsent())) {
                absentAttendance.add(attendance);
            }
        }
        
        return absentAttendance;

    } catch (ParseException e) {
        e.printStackTrace();
    }
    return null;
}






    public List<Attendance> getAttendanceBySid(String sid) {
        return attendanceRepo.findBySid(sid);
    }




     public List<AttendanceDetailDto> getAbsentStudentDetails(
            String date, String studentClass, String section) {
        try {
            Date parsedDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            return attendanceRepo.findAbsentStudentDetails(
                parsedDate, 
                studentClass.isEmpty() ? null : studentClass, 
                section.isEmpty() ? null : section
            );
        } catch (ParseException e) {
            e.printStackTrace();
            return Collections.emptyList();
   
   
        }
    }
}
