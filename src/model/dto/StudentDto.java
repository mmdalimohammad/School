package model.dto;

import java.util.Objects;

public class StudentDto {
    private long studentId;
    private String fullName;
    private String nationalCode;
    private double gpu;

    public StudentDto(long studentId, String fullName, String nationalCode, double gpu) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.nationalCode = nationalCode;
        this.gpu = gpu;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
        StudentDto that = (StudentDto) o;
        return studentId == that.studentId && Double.compare(gpu, that.gpu) == 0 && Objects.equals(fullName, that.fullName) && Objects.equals(nationalCode, that.nationalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, fullName, nationalCode, gpu);
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "studentId=" + studentId +
                ", fullName='" + fullName + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", gpu=" + gpu +
                '}';
    }
}
