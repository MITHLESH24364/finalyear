package com.example.finalyear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalyear.entity.Attendance;
import com.example.finalyear.repo.AttendenceRepo;

@Service
public class AttendenceService {
    @Autowired
    AttendenceRepo attendanceRepo;

    public Attendance addAttendance(Attendance attendance){
        return attendanceRepo.save(attendance);
    }

    public Attendance updateAttendance(Attendance attendance){
        Attendance attendanceDetail = attendanceRepo.getById(attendance.getId());
        attendanceDetail = attendance;
        return attendanceRepo.save(attendanceDetail);
    }

    public boolean deleteAttendance(long userId){
        Attendance attendanceDetail = attendanceRepo.getById(userId);
       if (attendanceDetail!=null) {
        attendanceRepo.delete(attendanceDetail);
        return true;
       } 
       return false;
    }

    public Attendance getAttendanceById(long attendanceId){
        return attendanceRepo.findById(attendanceId).orElse(null);
    }

    public List<Attendance> getAllAttendance(){
        return attendanceRepo.findAll();
    }
}
