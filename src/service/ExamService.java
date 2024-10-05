package service;

import model.Exam;

import java.sql.SQLException;

public interface ExamService {
    boolean addExam(Exam exam)throws SQLException;
    boolean updateExam(String name,Exam newExam)throws SQLException;
    boolean deleteExam(String name)throws SQLException;
    void printAllExams();
    Exam getExamByName(String ExamName) throws SQLException;

}
