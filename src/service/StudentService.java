package service;

import model.Student;

import java.sql.SQLException;

public interface StudentService {
    void printAllStudentList();
    void printCountOfStudent();
    Student generateStudent(String firstName, String lastName, String nationality) throws SQLException;
    boolean createStudent(Student student) throws SQLException;
    boolean removeStudent(String nationalCode)throws SQLException;
    boolean updateStudent(String nationalCode,Student newStudent)throws SQLException;
    Student getStudentNationalCode(String nationalCode)throws SQLException;
}
