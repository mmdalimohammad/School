package repository.impl;


import model.Exam;
import repository.ExamRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static data.Database.*;
import static data.Query.*;

public class ExamRepositoryImpl implements ExamRepository {


    @Override
    public boolean addExam(Exam exam) throws SQLException {
        PreparedStatement pst =getPreparedStatement(ADD_NEW_EXAM_DATA);
        pst.setString(1, exam.getExamName());
        pst.setDate(2, Date.valueOf(exam.getExamDate()));
        pst.setTime(3, Time.valueOf(exam.getExamTime()));
        pst.setInt(4,exam.getCourseId());
        return pst.executeUpdate() > 0;
    }

    @Override
    public boolean updateExam(Exam exam) throws SQLException {
        PreparedStatement pst=getPreparedStatement(UPDATE_EXAM_DATA);
        pst.setString(1,exam.getExamName());
        pst.setDate(2,Date.valueOf(exam.getExamDate()));
        pst.setTime(3,Time.valueOf(exam.getExamTime()));
        pst.setLong(4,exam.getExamId());
        return pst.executeUpdate() > 0;
    }

    @Override
    public boolean deleteExam(Exam exam) throws SQLException {
        PreparedStatement pst=getPreparedStatement(REMOVE_EXAM_DATA);
        pst.setInt(1, exam.getCourseId());
        return pst.executeUpdate() > 0;

    }


    @Override
    public List<Exam> getAllExams() throws SQLException {
        PreparedStatement pst=getPreparedStatement(GET_ALL_EXAM);
        ResultSet examResult=pst.executeQuery();
        List<Exam> exams=new ArrayList<>();
        while(examResult.next()){
            Exam exam=new Exam(
                    examResult.getLong("exam_id"),
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
    public Optional<Exam> getExamByName(String ExamName) throws SQLException {
        PreparedStatement pst=getPreparedStatement(GET_EXAM_FIND_BY_NAME);
        pst.setString(1, ExamName);
        ResultSet rs=pst.executeQuery();
        Optional<Exam> optionalExam=Optional.empty();
        if(rs.next()){
            Exam exam=new Exam(
                    rs.getLong("exam_id"),
                    rs.getString("exam_name"),
                    rs.getDate("date").toLocalDate(),
                    rs.getTime("time").toLocalTime(),
                    rs.getInt("course_id")
            );
            optionalExam=Optional.of(exam);
        }
        return optionalExam;
    }
}
