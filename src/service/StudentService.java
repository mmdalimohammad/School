package service;

import model.Student;

import java.sql.SQLException;
import java.time.LocalDate;

public interface StudentService {
    void printAllList();

    Student generate(String firstName, String lastName, LocalDate dob , String nationality) throws SQLException;
    boolean add(Student student) throws SQLException;
    boolean remove(String nationalCode)throws SQLException;
    boolean update(String nationalCode, Student newStudent)throws SQLException;
    Student getNationalCode(String nationalCode)throws SQLException;
    boolean signInStudent(int studentId, String nationalCode) throws SQLException;
}
