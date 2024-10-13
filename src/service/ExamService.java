package service;

import model.Exam;

import java.sql.SQLException;
import java.util.Optional;

public interface ExamService {
    boolean addExam(Exam exam)throws SQLException;
    boolean updateExam(String name,Exam newExam)throws SQLException;

    void printAllExams();
    Optional<Exam> getExamByName(String ExamName) throws SQLException;

}
