package com.example.finalyear.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.finalyear.dto.DepartmentDTO;
import com.example.finalyear.entity.Department;
import com.example.finalyear.entity.Staff;
import com.example.finalyear.repo.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addDepartment(DepartmentDTO departmentDTO) {
        if (departmentRepository.existsByDepartmentId(departmentDTO.getDepartmentId())) {
            throw new IllegalArgumentException("Department ID already exists!");
        }

        Department department = new Department();
        department.setDepartmentId(departmentDTO.getDepartmentId());
        department.setDepartmentName(departmentDTO.getDepartmentName());
        department.setHeadOfDepartment(departmentDTO.getHeadOfDepartment());
        department.setStartDate(departmentDTO.getStartDate());

        return departmentRepository.save(department);
    }

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public static List<Department> getAll(List<Department> departmentList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
     public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }


    public void updateDepartment(Long id, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Department not found with ID: " + id));
        
        department.setDepartmentName(departmentDTO.getDepartmentName());
        department.setHeadOfDepartment(departmentDTO.getHeadOfDepartment());
        department.setStartDate(departmentDTO.getStartDate());
    
        departmentRepository.save(department);
    }


    public void deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Department not found with ID: " + id));
        departmentRepository.delete(department);
    }
    
}
