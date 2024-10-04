package repository.impl;

import data.Database;
import model.Exam;
import repository.ExamRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static data.Query.*;

public class ExamRepositoryImpl implements ExamRepository {
    private Database database = new Database();

    @Override
    public boolean addExam(Exam exam) throws SQLException {
        PreparedStatement pst = database.getDatabaseConnection().prepareStatement(ADD_NEW_EXAM_DATA);
        pst.setString(1, exam.getExamName());
        pst.setDate(2, java.sql.Date.valueOf(exam.getExamDate()));
        pst.setTimestamp(3, java.sql.Timestamp.valueOf(exam.getExamTime()));
        return pst.executeUpdate() > 0;
    }



    @Override
    public boolean updateExam(Exam exam) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteExam(Exam exam) throws SQLException {
        return false;
    }

    @Override
    public List<Exam> getAllExams() throws SQLException {
        return List.of();
    }

    @Override
    public Exam getExamByName(String ExamName) throws SQLException {
        return null;
    }
}
