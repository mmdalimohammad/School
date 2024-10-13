package service;

import model.Student;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public interface StudentService {
    void printAllList();
    boolean add(Student student) throws SQLException;
    boolean remove(String nationalCode)throws SQLException;
    boolean update(String nationalCode, Student newStudent)throws SQLException;
    Optional<Student> getNationalCode(String nationalCode)throws SQLException;
    boolean signInStudent(int studentId, String nationalCode) throws SQLException;
}
