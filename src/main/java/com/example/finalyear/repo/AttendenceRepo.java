package com.example.finalyear.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.finalyear.dto.AttendanceDetailDto;
import com.example.finalyear.entity.Attendance;

@Repository
public interface AttendenceRepo extends JpaRepository<Attendance, Long> {

    List<Attendance> findByDate(Date date);

    @Query("SELECT a FROM Attendance a WHERE a.date = :date AND a.sid = :sid")
    List<Attendance> findByDateAndSid(Date date, String sid);

    List<Attendance> findBySid(String sid);

// @Query(value = "SELECT a.sid, a.date, a.absent, " +
//        "s.fullname, s.roll_no, s.student_class, s.section " +
//        "FROM attendance a " +
//        "JOIN students_detail s ON a.sid=CAST(s.account_id AS CHAR) " +
//        "WHERE a.date = :date " +
//        "AND (:student_class IS NULL OR s.student_class = :student_class) " +
//        "AND (:section IS NULL OR s.section = :section) " +
//        "AND a.absent = 'a'", nativeQuery = true)
       
// List<AttendanceDetailDto> findAbsentStudentDetails(
//         @Param("date") Date date,
//         @Param("student_class") String student_class,
//         @Param("section") String section);

    // @Query("SELECT new com.example.finalyear.dto.AttendanceDetailDto(" +
    // "a.sid, a.date, a.absent, " +
    // "s.fullname, s.rollNo, s.studentClass, s.section) " +
    // "FROM Attendance a " +
    // "JOIN StudentsDetail s ON a.sid = s.rollNo " +
    // "WHERE a.date = :date " +
    // "AND (:studentClass IS NULL OR s.studentClass = :studentClass) " +
    // "AND (:section IS NULL OR s.section = :section) " +
    // "AND a.absent = 'a'")
    // List<AttendanceDetailDto> findAbsentStudentDetails(
    // @Param("date") Date date,
    // @Param("studentClass") String studentClass,
    // @Param("section") String section
    // );



//     @Query("SELECT new com.example.finalyear.dto.AttendanceDetailDto(" +
// "a.sid, a.date, a.absent, " +
// "s.fullname, s.rollNo, s.studentClass, s.section) " +
// "FROM Attendance a " +
// "JOIN StudentsDetail s ON a.sid = s.accountId " +  // Updated to use accountId
// "WHERE a.date = :date " +
// "AND (:studentClass IS NULL OR s.studentClass = :studentClass) " +
// "AND (:section IS NULL OR s.section = :section) " +
// "AND a.absent = 'a'")
// List<AttendanceDetailDto> findAbsentStudentDetails(
//     @Param("date") Date date,
//     @Param("studentClass") String studentClass,
//     @Param("section") String section
// );


@Query("SELECT new com.example.finalyear.dto.AttendanceDetailDto(a.sid, a.date, a.absent, s.fullname, s.rollNo, s.studentClass, s.section) " +
       "FROM Attendance a " +
       "JOIN StudentsDetail s ON a.sid = CONCAT('', s.accountId) " +
       "WHERE a.date = :date " +
       "AND (:student_class IS NULL OR s.studentClass = :student_class) " +
       "AND (:section IS NULL OR s.section = :section) " +
       "AND a.absent = 'a'")
List<AttendanceDetailDto> findAbsentStudentDetails(
        @Param("date") Date date,
        @Param("student_class") String student_class,
        @Param("section") String section);


}
