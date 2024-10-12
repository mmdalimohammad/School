package service;

import model.Teacher;

import java.sql.SQLException;

public interface TeacherService {
    void printAllList();
    boolean add(Teacher teacher) throws SQLException;
    Teacher generate(String firstName, String lastName, String nationality) throws SQLException;
    boolean remove(String nationalCode) throws SQLException;
    boolean update(String nationalCode , Teacher newTeacher) throws SQLException;
    Teacher getNationalCode(String nationalCode)throws SQLException;
    boolean signInTeacher(int teacherId, String nationalCode) throws SQLException;
    void printAllStudent() ;
    boolean addScore(String nationalCode, double score) throws SQLException;


}
