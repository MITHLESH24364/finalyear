// package com.example.finalyear.config;

// import java.util.Date;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.crypto.password.PasswordEncoder;

// import com.example.finalyear.entity.Login;
// import com.example.finalyear.entity.Staff;
// import com.example.finalyear.entity.StudentsDetail;
// import com.example.finalyear.repo.LoginRepo;
// import com.example.finalyear.repo.StaffRepo;
// import com.example.finalyear.repo.StudentRepo;

// @Configuration
// public class DataInitConfig {

//     @Autowired
//     PasswordEncoder passwordEncoder;

//     @Bean
//     CommandLineRunner initDatabase(
//             LoginRepo loginRepository,
//             StaffRepo staffRepository,
//             StudentRepo studentsDetailRepository) {
                

//         return args -> {
//             // Create Staff
//             Staff staff = new Staff();
//             staff.setStaffId("STF001");
//             staff.setFullname("Mithlesh Singh");
//             staff.setGender(Staff.Gender.MALE);
//             staff.setDateOfBirth("2001-05-07");
//             staff.setEmail("singhmithlesh095@gmail.com");
//             staff.setPhoneNumber("9817622227");
//             staff.setLocation("Sarlahi");
//             staff.setBloodGroup(Staff.BloodGroup.B_PLUS);
//             staff.setDepartment("Science");
//             staff.setClassTeacher("10th Grade");
//             staff.setBlockHead("Block J");
//             staff.setImage("mithlesh_singh.png");
//             staff = staffRepository.save(staff);

//             // Create Student
//             StudentsDetail student = new StudentsDetail();
//             student.setFullname("Mithlesh Kumar Singh");
//             student.setGender("Male");
//             student.setDateOfBirth("2001-05-07");
//             student.setRollNo("1");
//             student.setLocation("Lalitpur");
//             student.setBloodGroup("B+");
//             student.setReligion("Hindu");
//             student.setEmail("singhmithlesh095@gmail.com");
//             student.setStudentClass("10");
//             student.setSection("A");
//             student.setNumber("9817622227");
//             student.setParentName("Ram Krishna Singh");
//             student.setParentNo("9867028164");
//             student.setImage("mks.png");
//             student = studentsDetailRepository.save(student);

//             // Create Login for Staff
//             Login staffLogin = new Login();
//             staffLogin.setUserId("STF001");
//             staffLogin.setUsername("mithlesh_singh");
//             staffLogin.setPassword(passwordEncoder.encode("root"));
//             staffLogin.setRole("STAFF");
//             staffLogin.setStaff(staff);
//             loginRepository.save(staffLogin);

//             // Create Login for Student
//             Login studentLogin = new Login();
//             studentLogin.setUserId("STD001");
//             studentLogin.setUsername("mks_singh");
//             studentLogin.setPassword(passwordEncoder.encode("password123"));
//             studentLogin.setRole("STUDENT");
//             studentLogin.setStudent(student);
//             loginRepository.save(studentLogin);
//         };
//     }
// }
