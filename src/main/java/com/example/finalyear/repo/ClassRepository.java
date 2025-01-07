// package com.example.finalyear.repo;


// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.example.finalyear.entity.ClassEntity;

// @Repository
// public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
// }



package com.example.finalyear.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.finalyear.entity.ClassEntity;
import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
    Optional<ClassEntity> findByClassNameAndSection(String className, String section);
}
