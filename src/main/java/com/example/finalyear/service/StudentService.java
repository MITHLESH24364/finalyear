package com.example.finalyear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalyear.entity.StudentsDetail;
import com.example.finalyear.repo.StudentRepo;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public StudentsDetail addStudentsDetail(StudentsDetail student){
        return studentRepo.save(student);
    }

    // public StudentsDetail updateStudentsDetail(StudentsDetail student){
    //     StudentsDetail studentDetail = studentRepo.getById(student.getAccountId());
    //     studentDetail = student;
    //     return studentRepo.save(studentDetail);
    // }

    public StudentsDetail updateStudentsDetail(long id, StudentsDetail student) {
        StudentsDetail studentDetail = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + student.getAccountId()));
        
        // Update the fields of the existing studentDetail
        studentDetail.setFullname(student.getFullname());
        studentDetail.setEmail(student.getEmail());
        studentDetail.setNumber(student.getNumber());
        studentDetail.setGender(student.getGender());
        studentDetail.setDateOfBirth(student.getDateOfBirth());
        studentDetail.setRollNo(student.getRollNo());
        studentDetail.setLocation(student.getLocation());
        studentDetail.setBloodGroup(student.getBloodGroup());
        studentDetail.setReligion(student.getReligion());
        studentDetail.setStudentClass(student.getStudentClass());
        studentDetail.setSection(student.getSection());
        studentDetail.setParentName(student.getParentName());
        studentDetail.setParentNo(student.getParentNo());
        
        // Update other fields as necessary
    
        return studentRepo.save(studentDetail);
    }
    


    public boolean deleteStudentsDetail(long userId){
        StudentsDetail studentDetail = studentRepo.getById(userId);
       if (studentDetail!=null) {
        studentRepo.delete(studentDetail);
        return true;
       } 
       return false;
    }

    public StudentsDetail getStudentsDetailById(long studentId){
        return studentRepo.findById(studentId).orElse(null);
    }

    public List<StudentsDetail> getAllStudentsDetail(){
        return studentRepo.findAll();
    }
}
