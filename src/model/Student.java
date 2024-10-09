package model;

import java.util.Date;
import java.util.Objects;
import java.time.LocalDate;

public class Student {
    private long studentId;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String nationalCode;
    private double gpu;


    public Student(long studentId, String firstName, String lastName, LocalDate dob, String nationalCode, double gpu) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.nationalCode = nationalCode;
        this.gpu = gpu;
    }


    public Student() {
    }

    public Student(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public Student(long studentId, String nationalCode) {
        this.studentId = studentId;
        this.nationalCode = nationalCode;
    }

    public Student(long studentId, String firstName, String lastName, LocalDate dob , String nationalCode) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.nationalCode = nationalCode;
    }

    public Student(String firstName, String lastName, LocalDate dob, String nationalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob=dob;
        this.nationalCode = nationalCode;
    }

    public Student(String firstName, String lastName, String nationalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
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

    public double getGpu() {
        return gpu;
    }

    public void setGpu(double gpu) {
        this.gpu = gpu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId && Double.compare(gpu, student.gpu) == 0 && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(dob, student.dob) && Objects.equals(nationalCode, student.nationalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, firstName, lastName, dob, nationalCode, gpu);
    }

    @Override

    public String toString() {
        return "Students{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", nationalCode='" + nationalCode + '\'' +
                ", gpu=" + gpu +
                '}';
    }
}
