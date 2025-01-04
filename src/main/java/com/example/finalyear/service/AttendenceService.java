package com.example.finalyear.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Attendance> addBulkAttendance(List<Attendance> attendances) {
        return attendanceRepo.saveAll(attendances);
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

}
