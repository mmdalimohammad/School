package model;

import java.util.Objects;

public class Course {
    private int courseId;
    private String courseTitle;
    private int courseUnit;

    public Course( String courseTitle, int courseUnit) {

        this.courseTitle = courseTitle;
        this.courseUnit = courseUnit;
    }

    public Course(int courseId, String courseTitle, int courseUnit) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseUnit = courseUnit;
    }


    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId == course.courseId && courseUnit == course.courseUnit && Objects.equals(courseTitle, course.courseTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseTitle, courseUnit);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + courseId +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseUnit=" + courseUnit +
                '}';
    }
}
