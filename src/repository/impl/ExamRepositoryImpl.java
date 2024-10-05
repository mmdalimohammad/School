package repository.impl;

import data.Database;
import model.Exam;
import repository.ExamRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static data.Query.*;

public class ExamRepositoryImpl implements ExamRepository {
    private Database database = new Database();

    @Override
    public boolean addExam(Exam exam) throws SQLException {
        PreparedStatement pst = database.getDatabaseConnection().prepareStatement(ADD_NEW_EXAM_DATA);
        pst.setString(1, exam.getExamName());
        pst.setDate(2, Date.valueOf(exam.getExamDate()));
        pst.setTime(3, Time.valueOf(exam.getExamTime()));
        pst.setInt(4,exam.getCourseId());
        return pst.executeUpdate() > 0;
    }



    @Override
    public boolean updateExam(Exam exam) throws SQLException {
        PreparedStatement pst= database.getDatabaseConnection().prepareStatement(UPDATE_EXAM_DATA);
        pst.setString(1,exam.getExamName());
        pst.setDate(2,Date.valueOf(exam.getExamDate()));
        pst.setTime(3,Time.valueOf(exam.getExamTime()));
        pst.setInt(4,exam.getCourseId());
        return pst.executeUpdate() > 0;
    }

    @Override
    public boolean deleteExam(Exam exam) throws SQLException {
        PreparedStatement pst=database.getDatabaseConnection().prepareStatement(REMOVE_EXAM_DATA);
        pst.setInt(1, exam.getCourseId());
        return pst.executeUpdate() > 0;

    }

    @Override
    public List<Exam> getAllExams() throws SQLException {
        ResultSet examResult=database.getSqlStatement().executeQuery(GET_ALL_EXAM);
        List<Exam> exams=new ArrayList<>();
        while(examResult.next()){
            Exam exam=new Exam(
                    examResult.getString("exam_name"),
                    examResult.getDate("date").toLocalDate(),
                    examResult.getTime("time").toLocalTime(),
                    examResult.getInt("course_id")
            );
            exams.add(exam);
        }
        return exams;
    }

    @Override
    public Exam getExamByName(String ExamName) throws SQLException {
        PreparedStatement pst=database.getDatabaseConnection().prepareStatement(GET_EXAM_FIND_BY_NAME);
        pst.setString(1, ExamName);
        ResultSet rs=pst.executeQuery();
        if(rs.next()){
            return new Exam(
                    rs.getLong("exam_id"),
                    rs.getString("exam_name"),
                    rs.getDate("date").toLocalDate(),
                    rs.getTime("time").toLocalTime(),
                    rs.getInt("course_id")
            );
        }
        return null;
    }
}
