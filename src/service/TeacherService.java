package service;

import model.Teacher;

import java.sql.SQLException;
import java.util.Optional;

public interface TeacherService {
    void printAllList();
    boolean add(Teacher teacher) throws SQLException;
    boolean remove(String nationalCode) throws SQLException;
    boolean update(String nationalCode , Teacher newTeacher) throws SQLException;
    Optional<Teacher> getNationalCode(String nationalCode)throws SQLException;
    boolean signInTeacher(int teacherId, String nationalCode) throws SQLException;
    void printAllStudent() ;
    boolean addScore(String nationalCode,int courseId ,double score) throws SQLException;


}
