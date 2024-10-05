package model;

import java.sql.Date;
import java.sql.SQLData;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Exam {
    private Long examId;
    private String examName;
    private LocalDate examDate;
    private LocalTime examTime;
    private int courseId;


    public Exam(Long examId, String examName, LocalDate examDate, LocalTime examTime, int courseId) {
        this.examId = examId;
        this.examName = examName;
        this.examDate = examDate;
        this.examTime = examTime;
        this.courseId = courseId;
    }

    public Exam(String examName, LocalDate examDate, LocalTime examTime, int courseId) {
        this.examName = examName;
        this.examDate = examDate;
        this.examTime = examTime;
        this.courseId = courseId;
    }

    public Exam(String examName, LocalDate examDate, LocalTime examTime) {
        this.examName = examName;
        this.examDate = examDate;
        this.examTime = examTime;
    }

    public Exam(LocalDate examDate, LocalTime examTime) {
        this.examDate = examDate;
        this.examTime = examTime;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public LocalTime getExamTime() {
        return examTime;
    }

    public void setExamTime(LocalTime examTime) {
        this.examTime = examTime;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return courseId == exam.courseId && Objects.equals(examId, exam.examId) && Objects.equals(examName, exam.examName) && Objects.equals(examDate, exam.examDate) && Objects.equals(examTime, exam.examTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examId, examName, examDate, examTime, courseId);
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", examName='" + examName + '\'' +
                ", examDate=" + examDate +
                ", examTime=" + examTime +
                ", courseId=" + courseId +
                '}';
    }
}
