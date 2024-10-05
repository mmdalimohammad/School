package service;

import model.Student;

import java.sql.SQLException;
import java.time.LocalDate;

public interface StudentService {
    void printAllStudentList();
    void printCountOfStudent();
    Student generateStudent(String firstName, String lastName, LocalDate dob , String nationality) throws SQLException;
    boolean createStudent(Student student) throws SQLException;
    boolean removeStudent(String nationalCode)throws SQLException;
    boolean updateStudent(String nationalCode,Student newStudent)throws SQLException;
    Student getStudentNationalCode(String nationalCode)throws SQLException;
    boolean signIn(int studentId, String nationalCode) throws SQLException;
}
