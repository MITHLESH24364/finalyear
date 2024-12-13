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

    public StudentsDetail updateStudentsDetail(StudentsDetail student){
        StudentsDetail studentDetail = studentRepo.getById(student.getAccountId());
        studentDetail = student;
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
