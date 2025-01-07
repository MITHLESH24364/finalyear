package com.example.finalyear.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalyear.dto.SubjectDTO;
import com.example.finalyear.entity.Subject;
import com.example.finalyear.repo.SubjectRepository;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Subject saveSubject(SubjectDTO subjectDTO) {
        Subject subject = new Subject();
        subject.setSubjectId(subjectDTO.getSubjectId());
        subject.setSubjectName(subjectDTO.getSubjectName());
        subject.setSubjectClass(subjectDTO.getSubjectClass());

        return subjectRepository.save(subject);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found with ID: " + id));
    }

  public void updateSubject(Long id, SubjectDTO subjectDTO) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subject not found with ID: " + id));
        
        subject.setSubjectId(subjectDTO.getSubjectId());
        subject.setSubjectName(subjectDTO.getSubjectName());
        subject.setSubjectClass(subjectDTO.getSubjectClass());

        subjectRepository.save(subject);

}

public void deleteSubject(Long id) {
    Subject subject = subjectRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Subject not found with ID: " + id));
    subjectRepository.delete(subject);
}
}
 