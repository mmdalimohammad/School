package model;

import java.sql.Date;
import java.sql.SQLData;
import java.sql.Time;
import java.util.Objects;

public class Exam {
    private Long examId;
    private String examName;
    private String examDate;
    private String examTime;
    private int courseId;


    public Exam(Long examId, String examName, String examDate, String examTime, int courseId) {
        this.examId = examId;
        this.examName = examName;
        this.examDate = examDate;
        this.examTime = examTime;
        this.courseId = courseId;
    }

    public Exam(String examName, String examDate, String examTime) {
        this.examName = examName;
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

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
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
                ", examDate='" + examDate + '\'' +
                ", examTime='" + examTime + '\'' +
                ", courseId=" + courseId +
                '}';
    }
}
