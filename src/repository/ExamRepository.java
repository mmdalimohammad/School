package repository;

import model.Exam;

import java.sql.SQLException;
import java.util.List;

public interface ExamRepository {
    boolean addExam(Exam exam) throws SQLException;
    boolean updateExam(Exam exam) throws SQLException;
    boolean deleteExam(Exam exam) throws SQLException;
    List<Exam> getAllExams() throws SQLException;
    Exam getExamByName(String ExamName) throws SQLException;

}
