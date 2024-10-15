package service.impl;

import model.Exam;
import repository.ExamRepository;
import service.ExamService;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


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
        Optional<Exam> optionalExam = er.getExamByName(name);
        if (optionalExam.isEmpty() || newExam == null) {
            throw new IllegalArgumentException("exam is null");
        } else {
            newExam.setExamId(optionalExam.get().getExamId());
            newExam.setExamName(name);
            return er.updateExam(newExam);
        }
    }


    @Override
    public void printAllExams() {
        try {
            List<Exam> exams = er.getAllExams();
            System.out.format("\033[1;35m" + "+------+----------------+-------------+------------+%n");
            System.out.format("\033[1;35m" + "| ID   | Exam name      | Exam Date   | Exam Time  |%n");
            System.out.format("\033[1;35m" + "+------+----------------+-------------+------------+%n");
            for (Exam exam : exams) {
                System.out.printf("\033[1;35m" + "|" + "\033[1;34m" + " %-4s" + "\033[1;35m" + " |" + "\033[1;34m" + " %-14s" + "\033[1;35m" + " |" + "\033[1;34m" + " %-11s" + "\033[1;35m" + " |" + "\033[1;34m" + " %-11s" + "\033[1;35m" + "|" + "\n",
                        exam.getExamId(),
                        exam.getExamName(),
                        exam.getExamDate(),
                        exam.getExamTime());
            }
            System.out.format("\033[1;35m" + "+------+----------------+-------------+------------+%n");
        } catch (SQLException sqlException) {
            System.out.println("there is problem with connecting to database");
        }
        System.out.println("\033[0m");
    }

    @Override
    public Optional<Exam> getExamByName(String ExamName) throws SQLException {
        if (er.getExamByName(ExamName).isPresent()) {
            throw new IllegalArgumentException("name already exists");
        } else {
            return er.getExamByName(ExamName);
        }
    }


}
