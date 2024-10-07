package service.impl;

import model.Exam;
import repository.ExamRepository;
import service.ExamService;

import java.sql.SQLException;
import java.util.List;


public class ExamServiceImpl implements ExamService {

    private ExamRepository er;

    public ExamServiceImpl(ExamRepository er) {
        this.er = er;
    }

    @Override
    public boolean addExam(Exam exam) throws SQLException {
        if (exam == null) {
            throw new SQLException("exam is null");
        } else {
            return er.addExam(exam);
        }
    }

    @Override
    public boolean updateExam(String name, Exam newExam) throws SQLException {
        if (er.getExamByName(name) == null || newExam == null) {
            throw new IllegalArgumentException("exam is null");
        } else {
            return er.updateExam(newExam);
        }
    }

    @Override
    public boolean deleteExam(String name) throws SQLException {
        return er.deleteExam(er.getExamByName(name));
    }

    @Override
    public void printAllExams() {
        try {
            List<Exam> exams = er.getAllExams();
            System.out.printf("\u001B[35m" + "%-7s %-13s %-13s %-17s\n", "id", "name", "Date", "Time");
            for (Exam exam : exams) {
                System.out.printf("%-7s %-13s %-13s %-17s\n",
                        exam.getExamId(),
                        exam.getExamName(),
                        exam.getExamDate(),
                        exam.getExamTime());
            }
        } catch (SQLException sqlException) {
            System.out.println("there is problem with connecting to database");
        }
    }

    @Override
    public Exam getExamByName(String ExamName) throws SQLException {
        if (er.getExamByName(ExamName) == null) {
            throw new IllegalArgumentException("name already exists");
        } else {
            return er.getExamByName(ExamName);
        }
    }


}
