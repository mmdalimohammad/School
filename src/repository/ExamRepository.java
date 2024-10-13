package repository;

import model.Exam;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ExamRepository {
    boolean addExam(Exam exam) throws SQLException;
    boolean updateExam(Exam exam) throws SQLException;
    boolean deleteExam(Exam exam) throws SQLException;
    List<Exam> getAllExams() throws SQLException;
    Optional<Exam> getExamByName(String ExamName) throws SQLException;

}
