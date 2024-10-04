package repository;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentRepository {
    List<Student> getAllStudents()throws SQLException;
    int getCountOfStudent()throws SQLException;
    boolean createStudent(Student student)throws SQLException;
    boolean removeStudent(Student student)throws SQLException;
    Student getStudentByNationalCode(String nationalCode)throws SQLException;
    boolean updateStudent(Student student)throws SQLException;

}
