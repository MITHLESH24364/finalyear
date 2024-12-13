package com.example.finalyear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalyear.entity.Marks;
import com.example.finalyear.repo.MarksRepo;

@Service
public class MarkService {
    @Autowired
    MarksRepo markRepo;

    public Marks addMarks(Marks mark){
        return markRepo.save(mark);
    }

    public Marks updateMarks(Marks mark){
        Marks markDetail = markRepo.getById(mark.getId());
        markDetail = mark;
        return markRepo.save(markDetail);
    }

    public boolean deleteMarks(long userId){
        Marks markDetail = markRepo.getById(userId);
       if (markDetail!=null) {
        markRepo.delete(markDetail);
        return true;
       } 
       return false;
    }

    public Marks getMarksById(long markId){
        return markRepo.findById(markId).orElse(null);
    }

    public List<Marks> getAllMarks(){
        return markRepo.findAll();
    }
}
