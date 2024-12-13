package com.example.finalyear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalyear.entity.Staff;
import com.example.finalyear.repo.StaffRepo;

@Service
public class StaffService {
    @Autowired
    StaffRepo staffRepo;

    public Staff addStaff(Staff staff){
        return staffRepo.save(staff);
    }

    public Staff updateStaff(Staff staff){
        Staff staffDetail = staffRepo.getById(staff.getId());
        staffDetail = staff;
        return staffRepo.save(staffDetail);
    }

    public boolean deleteStaff(long userId){
        Staff staffDetail = staffRepo.getById(userId);
       if (staffDetail!=null) {
        staffRepo.delete(staffDetail);
        return true;
       } 
       return false;
    }

    public Staff getStaffById(long staffId){
        return staffRepo.findById(staffId).orElse(null);
    }

    public List<Staff> getAllStaff(){
        return staffRepo.findAll();
    }

}
