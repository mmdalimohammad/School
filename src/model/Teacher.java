package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Teacher {

    private Long teacherId;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String nationalCode;
    private int courseID;

    public Teacher(Long teacherId, String firstName, String lastName, LocalDate dob, String nationalCode, int courseID) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.nationalCode = nationalCode;
        this.courseID = courseID;
    }

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String nationalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
    }

    public Teacher(long teacherId, String firstName, String lastName, String nationalCode) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
    }

    public Teacher(Long teacherId, String firstName, String lastName, LocalDate dob, String nationalCode) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.nationalCode = nationalCode;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return teacherId == teacher.teacherId && Objects.equals(firstName, teacher.firstName) && Objects.equals(lastName, teacher.lastName) && Objects.equals(dob, teacher.dob) && Objects.equals(nationalCode, teacher.nationalCode) && Objects.equals(courseID, teacher.courseID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, firstName, lastName, dob, nationalCode, courseID);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", nationalCode='" + nationalCode + '\'' +
                ", courseID=" + courseID +
                '}';
    }
}
