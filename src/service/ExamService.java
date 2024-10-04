package service;

import model.Exam;

import java.sql.SQLException;

public interface ExamService {
    boolean addExam(Exam exam)throws SQLException;

}
