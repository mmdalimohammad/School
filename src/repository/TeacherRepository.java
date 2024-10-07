package repository;

import model.Student;
import model.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherRepository {

    List<Teacher> getAllTeacher() throws SQLException;

    int getCountOfTeacher() throws SQLException;
    boolean createTeacher(Teacher teacher) throws SQLException;
    boolean removeTeacher(Teacher teacher) throws SQLException;
    Teacher getTeacherByNationalCode(String nationalCode) throws SQLException;
    boolean updateTeacher(Teacher teacher) throws SQLException;
    Teacher getTeacherByIdAndNationalCode(int id, String nationalCode) throws SQLException;
}
