package service;

import model.Student;
import model.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherService {
    void printAllTeacherList();
    void printCountOfTeacher();
    boolean createTeacher(Teacher teacher) throws SQLException;
    Teacher generateTeacher(String firstName, String lastName, String nationality) throws SQLException;
    boolean removeTeacher(String nationalCode) throws SQLException;
    boolean updateTeacher(String nationalCode ,Teacher newTeacher) throws SQLException;
    Teacher getTeacherNationalCode(String nationalCode)throws SQLException;
    boolean signInTeacher(int teacherId, String nationalCode) throws SQLException;


}
