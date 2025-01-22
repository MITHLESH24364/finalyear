// package com.example.finalyear.controller;


// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.finalyear.dto.ClassDTO;
// import com.example.finalyear.entity.ClassEntity;
// import com.example.finalyear.service.ClassService;

// @RestController
// @RequestMapping("/sms/classes")
// public class ClassController {

//     @Autowired
//     private ClassService classService;

//     @PostMapping("/add")
//     public ResponseEntity<ClassEntity> addClass(@RequestBody ClassDTO classDTO) {
//         ClassEntity createdClass = classService.addClass(classDTO);
//         return ResponseEntity.ok(createdClass);
//     }

//     @GetMapping("/all")
//     public ResponseEntity<List<ClassEntity>> getAllClasses() {
//         List<ClassEntity> classes = classService.getAllClassEntity();
//         return ResponseEntity.ok(classes);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<ClassEntity> getClassById(@PathVariable Long id) {
//         return ResponseEntity.ok(classService.getClassById(id));
//     }

//     @PutMapping("/update/{id}")
//     public ResponseEntity<String> updateClass(@PathVariable Long id, @RequestBody ClassDTO classDTO) {
//         try {
//             classService.updateClass(id, classDTO);
//             return ResponseEntity.ok("Class updated successfully!");
//         } catch (IllegalArgumentException e) {
//             return ResponseEntity.badRequest().body(e.getMessage());
//         } catch (Exception e) {
//             return ResponseEntity.internalServerError().body("Failed to update Class.");
//         }
//     }

//     @DeleteMapping("/delete/{id}")
//     public ResponseEntity<String> deleteClass(@PathVariable Long id) {
//         try {
//             classService.deleteClass(id);
//             return ResponseEntity.ok("Class deleted successfully!");
//         } catch (IllegalArgumentException e) {
//             return ResponseEntity.badRequest().body(e.getMessage());
//         } catch (Exception e) {
//             return ResponseEntity.internalServerError().body("Failed to delete Class.");
//         }
//     }
// }



package com.example.finalyear.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.finalyear.dto.ClassDTO;
import com.example.finalyear.entity.ClassEntity;
import com.example.finalyear.service.ClassService;

@RestController
@RequestMapping("/sms/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping("/add")
    public ResponseEntity<ClassEntity> addClass(@RequestBody ClassDTO classDTO) {
        ClassEntity createdClass = classService.addClass(classDTO);
        return ResponseEntity.ok(createdClass);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClassEntity>> getAllClasses() {
        List<ClassEntity> classes = classService.getAllClassEntity();
        return ResponseEntity.ok(classes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassEntity> getClassById(@PathVariable Long id) {
        return ResponseEntity.ok(classService.getClassById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateClass(@PathVariable Long id, @RequestBody ClassDTO classDTO) {
        try {
            classService.updateClass(id, classDTO);
            return ResponseEntity.ok("Class updated successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to update Class.");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClass(@PathVariable Long id) {
        try {
            classService.deleteClass(id);
            return ResponseEntity.ok("Class deleted successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to delete Class.");
        }
    }
}
 