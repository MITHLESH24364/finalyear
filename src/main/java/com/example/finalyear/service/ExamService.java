package com.example.finalyear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalyear.entity.Exam;
import com.example.finalyear.repo.ExamsRepo;

@Service
public class ExamService {
    @Autowired
    ExamsRepo examRepo;

    public Exam addExam(Exam exam){
        return examRepo.save(exam);
    }

    public Exam updateExam(Exam exam){
        Exam examDetail = examRepo.getById(exam.getId());
        examDetail = exam;
        return examRepo.save(examDetail);
    }

    public boolean deleteExam(long userId){
        Exam examDetail = examRepo.getById(userId);
       if (examDetail!=null) {
        examRepo.delete(examDetail);
        return true;
       } 
       return false;
    }

    public Exam getExamById(long examId){
        return examRepo.findById(examId).orElse(null);
    }

    public List<Exam> getAllExam(){
        return examRepo.findAll();
    }
}
