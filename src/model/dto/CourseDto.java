package model.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class CourseDto {
    private String courseTitle;
    private int courseUnit;
    private String teacherName;
    private LocalDate examDate;
    private LocalTime examTime;

    public CourseDto(String courseName, int courseUnit, String teacherName, LocalDate examDate, LocalTime examTime) {
        this.courseTitle = courseName;
        this.courseUnit = courseUnit;
        this.teacherName = teacherName;
        this.examDate = examDate;
        this.examTime = examTime;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCourseUnit() {
        return courseUnit;
    }

    public void setCourseUnit(int courseUnit) {
        this.courseUnit = courseUnit;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseDto courseDto = (CourseDto) o;
        return courseUnit == courseDto.courseUnit && Objects.equals(courseTitle, courseDto.courseTitle) && Objects.equals(teacherName, courseDto.teacherName) && Objects.equals(examDate, courseDto.examDate) && Objects.equals(examTime, courseDto.examTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseTitle, courseUnit, teacherName, examDate, examTime);
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "courseName='" + courseTitle + '\'' +
                ", courseUnit=" + courseUnit +
                ", teacherName='" + teacherName + '\'' +
                ", examDate=" + examDate +
                ", examTime=" + examTime +
                '}';
    }
}
