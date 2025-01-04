package com.example.finalyear.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.yaml.snakeyaml.error.Mark; // This import is not needed

import com.example.finalyear.entity.Attendance;
import com.example.finalyear.entity.Marks;
import com.example.finalyear.repo.MarksRepo;

@Service
public class MarkService {
    @Autowired
    MarksRepo markRepo;

    // public Marks addMarks(Marks mark) {
    //     return markRepo.save(mark);
    // }

    // public Marks updateMarks(Marks mark) {
    //     Marks markDetail = markRepo.getById(mark.getId());
    //     markDetail = mark;
    //     return markRepo.save(markDetail);
    // }

    public Marks addOrUpdateMarks(Marks mark) {
        // Check if a record already exists for the given studentId, year, and term
        Marks existingMark = markRepo.findByStudentIdAndYearAndTerm(mark.getStudentId(), mark.getYear(), mark.getTerm());

        if (existingMark != null) {
            // Update fields with non-null values from the input
            if (mark.getEnglish() != null) existingMark.setEnglish(mark.getEnglish());
            if (mark.getNepali() != null) existingMark.setNepali(mark.getNepali());
            if (mark.getMath() != null) existingMark.setMath(mark.getMath());
            if (mark.getScience() != null) existingMark.setScience(mark.getScience());
            if (mark.getSocial() != null) existingMark.setSocial(mark.getSocial());
            if (mark.getOptMath() != null) existingMark.setOptMath(mark.getOptMath());
            if (mark.getOptEnglish() != null) existingMark.setOptEnglish(mark.getOptEnglish());
            if (mark.getOptComputer() != null) existingMark.setOptComputer(mark.getOptComputer());
            if (mark.getOptAccountancy() != null) existingMark.setOptAccountancy(mark.getOptAccountancy());
            if (mark.getOptScience() != null) existingMark.setOptScience(mark.getOptScience());
            return markRepo.save(existingMark);
        }

        // Save new record if no existing record is found
        return markRepo.save(mark);
    }


    public boolean deleteMarks(long userId) {
        Marks markDetail = markRepo.getById(userId);
        if (markDetail != null) {
            markRepo.delete(markDetail);
            return true;
        }
        return false;
    }

    public Marks getMarksById(long markId) {
        return markRepo.findById(markId).orElse(null);
    }

    public List<Marks> getAllMarks() {
        return markRepo.findAll();
    }

    public List<Marks> addBulkMarks(List<Marks> marks) {
        return markRepo.saveAll(marks);
    }


}
