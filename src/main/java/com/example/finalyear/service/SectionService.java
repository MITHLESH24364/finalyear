package com.example.finalyear.service;

import com.example.finalyear.dto.SectionDTO;
import com.example.finalyear.entity.SectionEntity;
import com.example.finalyear.repo.SectionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    public SectionEntity addSection(SectionDTO sectionDTO) {
        SectionEntity sectionEntity = new SectionEntity();
        sectionEntity.setSectionName(sectionDTO.getSectionName());
        sectionEntity.setClassId(sectionDTO.getClassId());
        return sectionRepository.save(sectionEntity);
    }

    public List<SectionEntity> getAllSections() {
        return sectionRepository.findAll();
    }

    public SectionEntity getSectionById(Long id) {
        return sectionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Section not found with ID: " + id));
    }

    public void updateSection(Long id, SectionDTO sectionDTO) {
        SectionEntity sectionEntity = sectionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Section not found with ID: " + id));
        
        sectionEntity.setSectionName(sectionDTO.getSectionName());
        sectionEntity.setClassId(sectionDTO.getClassId());

        sectionRepository.save(sectionEntity);

    }
    
    public void deleteSection(Long id) {
        SectionEntity sectionEntity = sectionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Section not found with ID: " + id));
        sectionRepository.delete(sectionEntity);
    }

    public List<SectionEntity> getSectionsByClassId(Long classId) {
        return sectionRepository.findByClassId(classId);
    }

    
    
}
 