package com.example.finalyear.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.finalyear.entity.Login;
import com.example.finalyear.entity.Staff;
import com.example.finalyear.entity.StudentsDetail;
import com.example.finalyear.repo.LoginRepo;
import com.example.finalyear.repo.StaffRepo;
import com.example.finalyear.repo.StudentRepo;

@Configuration
public class DataInitConfig {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner initDatabase(
            LoginRepo loginRepository,
            StaffRepo staffRepository,
            StudentRepo studentsDetailRepository) {
                

        return args -> {
            // Create Staff
            Staff staff = new Staff();
            staff.setStaffId("STF001");
            staff.setFullname("John Doe");
            staff.setGender(Staff.Gender.MALE);
            staff.setDateOfBirth("1985-04-15");
            staff.setEmail("john.doe@example.com");
            staff.setPhoneNumber("9876543210");
            staff.setLocation("Kathmandu");
            staff.setBloodGroup(Staff.BloodGroup.A_PLUS);
            staff.setDepartment("Science");
            staff.setClassTeacher("10th Grade");
            staff.setBlockHead("Block A");
            staff.setImage("john_doe_image.png");
            staff = staffRepository.save(staff);

            // Create Student
            StudentsDetail student = new StudentsDetail();
            student.setFullname("Jane Smith");
            student.setGender("Female");
            student.setDateOfBirth("2005-03-21");
            student.setRollNo("10A-001");
            student.setLocation("Lalitpur");
            student.setBloodGroup("O+");
            student.setReligion("Hindu");
            student.setEmail("jane.smith@example.com");
            student.setStudentClass("10th Grade");
            student.setSection("A");
            student.setNumber("9841234567");
            student.setParentName("Mr. Smith");
            student.setParentNo("9812345678");
            student.setImage("jane_smith_image.png");
            student = studentsDetailRepository.save(student);

            // Create Login for Staff
            Login staffLogin = new Login();
            staffLogin.setUserId("STF001");
            staffLogin.setUsername("john_doe");
            staffLogin.setPassword(passwordEncoder.encode("password123"));
            staffLogin.setRole("STAFF");
            staffLogin.setStaff(staff);
            loginRepository.save(staffLogin);

            // Create Login for Student
            Login studentLogin = new Login();
            studentLogin.setUserId("STD001");
            studentLogin.setUsername("jane_smith");
            studentLogin.setPassword(passwordEncoder.encode("password123"));
            studentLogin.setRole("STUDENT");
            studentLogin.setStudent(student);
            loginRepository.save(studentLogin);
        };
    }
}
