package com.example.finalyear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.finalyear.dto.LoginDto;
import com.example.finalyear.dto.StaffDTO;
import com.example.finalyear.entity.Login;
import com.example.finalyear.entity.Staff;
import com.example.finalyear.repo.LoginRepo;
import com.example.finalyear.repo.StaffRepo;

@Service
public class StaffService {
    @Autowired
    StaffRepo staffRepo;

    @Autowired
    LoginRepo loginRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Staff addStaff(StaffDTO staff){
        Staff staffData = new Staff();
        staffData.setImage(staff.getTeacherPhoto());
        staffData.setStaffId(staff.getStaffId());
        staffData.setFullname(staff.getFullname());
        staffData.setGender(Staff.Gender.valueOf(staff.getGender()));
        staffData.setDateOfBirth(staff.getDateOfBirth());
        staffData.setEmail(staff.getEmail());
        staffData.setPhoneNumber(staff.getPhoneNumber());
        staffData.setLocation(staff.getLocation());
        staffData.setBloodGroup(Staff.BloodGroup.valueOf(staff.getBloodGroup()));
        staffData.setDepartment(staff.getDepartment());
        staffData.setClassTeacher(staff.getClassTeacher());
        staffData.setBlockHead(staff.getBlockHead());

        Staff s = staffRepo.save(staffData);

        Login login = new Login();
        login.setUserId(String.valueOf(s.getId()));
        login.setUsername(staff.getUsername());
        login.setPassword(passwordEncoder.encode(staff.getPassword()));
        login.setRole("TEACHER");
        login.setStaff(s);

        loginRepo.save(login);

        return s;
        
    }

    // public Staff updateStaff(StaffDTO staff){
    //     Staff staffData = staffRepo.getById(staff.getId());
    //     staffData.setImage(staff.getTeacherPhoto());
    //     staffData.setStaffId(staff.getStaffId());
    //     staffData.setFullname(staff.getFullname());
    //     staffData.setGender(Staff.Gender.valueOf(staff.getGender()));
    //     staffData.setDateOfBirth(staff.getDateOfBirth());
    //     staffData.setEmail(staff.getEmail());
    //     staffData.setPhoneNumber(staff.getPhoneNumber());
    //     staffData.setLocation(staff.getLocation());
    //     staffData.setBloodGroup(Staff.BloodGroup.valueOf(staff.getBloodGroup()));
    //     staffData.setDepartment(staff.getDepartment());
    //     staffData.setClassTeacher(staff.getClassTeacher());
    //     staffData.setBlockHead(staff.getBlockHead());

    //     Staff s = staffRepo.save(staffData);

    //     Login login = new Login();
    //     login.setUserId(String.valueOf(s.getId()));
    //     login.setUsername(staff.getUsername());
    //     login.setPassword(passwordEncoder.encode(staff.getPassword()));
    //     login.setRole("Teacher");
    //     login.setStaff(s);

    //     loginRepo.save(login);

    //     return s;
    // }

    public Staff updateStaff(long id, Staff staff) {
        Staff staffData = staffRepo.findById(id).orElseThrow(() -> new RuntimeException("Staff not found: " + id));
    
        // Update only if new data is provided
        
        if (staff.getStaffId() != null) staffData.setStaffId(staff.getStaffId());
        if (staff.getFullname() != null) staffData.setFullname(staff.getFullname());
        if (staff.getGender() != null) staffData.setGender(staff.getGender());
        if (staff.getDateOfBirth() != null) staffData.setDateOfBirth(staff.getDateOfBirth());
        if (staff.getEmail() != null) staffData.setEmail(staff.getEmail());
        if (staff.getPhoneNumber() != null) staffData.setPhoneNumber(staff.getPhoneNumber());
        if (staff.getLocation() != null) staffData.setLocation(staff.getLocation());
        if (staff.getBloodGroup() != null) staffData.setBloodGroup(staff.getBloodGroup());
        if (staff.getDepartment() != null) staffData.setDepartment(staff.getDepartment());
        if (staff.getClassTeacher() != null) staffData.setClassTeacher(staff.getClassTeacher());
        if (staff.getBlockHead() != null) staffData.setBlockHead(staff.getBlockHead());
        if (staff.getImage() != null) staffData.setImage(staff.getImage());
    
        Staff updatedStaff = staffRepo.save(staffData);
    
        // Login login = loginRepo.findById(updatedStaff.getId()).orElse(new Login());
        // login.setUserId(String.valueOf(updatedStaff.getId()));
        // login.setUsername(staff.getgetUsername());
        // login.setPassword(passwordEncoder.encode(staff.getPassword()));
        // login.setRole("TEACHER");
        // login.setStaff(updatedStaff);
    
        // loginRepo.save(login);
    
        return updatedStaff;
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

