// package com.example.finalyear.service;


// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.finalyear.dto.ClassDTO;
// import com.example.finalyear.entity.ClassEntity;
// import com.example.finalyear.repo.ClassRepository;

// @Service
// public class ClassService {

//     @Autowired
//     private ClassRepository classRepository;

//     public ClassEntity addClass(ClassDTO classDTO) {
//         ClassEntity classEntity = new ClassEntity();
//         classEntity.setClassName(classDTO.getClassName());
//         classEntity.setSection(classDTO.getSection());
//         return classRepository.save(classEntity);
//     }
// }



package com.example.finalyear.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.finalyear.dto.ClassDTO;
import com.example.finalyear.entity.ClassEntity;
import com.example.finalyear.repo.ClassRepository;
import java.util.Optional;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public ClassEntity addClass(ClassDTO classDTO) {
        // Check if the class and section combination already exists
        Optional<ClassEntity> existingClass = classRepository.findByClassNameAndSection(classDTO.getClassName(), classDTO.getSection());
        if (existingClass.isPresent()) {
            throw new RuntimeException("Class and Section already exist");
        }

        // Save the new class
        ClassEntity classEntity = new ClassEntity();
        classEntity.setClassName(classDTO.getClassName());
        classEntity.setSection(classDTO.getSection());
        return classRepository.save(classEntity);
    }

    public List<ClassEntity> getAllClassEntity() {
        return classRepository.findAll();
    }

    public ClassEntity getClassById(Long id) {
        return classRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Class not found with ID: " + id));
    }
    

    public void updateClass(Long id, ClassDTO classDTO) {
        ClassEntity classEntity = classRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Class not found with ID: " + id));
        
        classEntity.setClassName(classDTO.getClassName());
        classEntity.setSection(classDTO.getSection());

        classRepository.save(classEntity);

    }

    public void deleteClass(Long id) {
        ClassEntity classEntity = classRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Class not found with ID: " + id));
        classRepository.delete(classEntity);
    }
    
}
