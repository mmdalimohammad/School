package service.impl;

import model.Student;
import repository.StudentRepository;
import service.StudentService;
import util.SecurityContext;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class StudentServiceImpl implements StudentService {





    private StudentRepository sr;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.sr=studentRepository;
    }


    @Override
    public void printAllStudentList() {
        try {
            List<Student> students = sr.getAllStudents();
            System.out.printf("\u001B[35m"+"%-7s %-13s %-13s %-13s %-17s\n", "id", "first name", "last name","Dob","national code");
            for (Student student : students) {
                System.out.printf("%-7s %-13s %-13s %-13s %-17s\n",
                        student.getStudentId(),
                        student.getFirstName(),
                        student.getLastName(),
                        student.getDob(),
                        student.getNationalCode());
            }

        } catch (SQLException sqlException) {
            System.out.println("there is problem with connecting to database");
        }
        System.out.println("\033[0m");
    }




    @Override
    public void printCountOfStudent() {
        try {
            int countOfStudent = sr.getCountOfStudent();
            System.out.println("# student: ".concat(String.valueOf(countOfStudent)));
        } catch (SQLException sqlException) {
            System.out.println("there is problem with connecting to database");
        }
    }
    @Override
    public Student generateStudent(String firstName, String lastName, LocalDate dob, String nationalCode) throws SQLException {
        if (sr.getStudentByNationalCode(nationalCode)!=null){
            throw new IllegalArgumentException("nationalCode already exists");
        }else {
            return new Student(firstName, lastName, dob,nationalCode);
        }
    }

    @Override
    public boolean createStudent(Student student) throws SQLException {
        if (student==null){
            throw new IllegalArgumentException("student cannot be null");
        }
        return sr.createStudent(student);
    }

    @Override
    public boolean removeStudent(String nationalCode) throws SQLException {
    return sr.removeStudent(sr.getStudentByNationalCode(nationalCode));
    }

    @Override
    public boolean updateStudent(String nationalCode,Student newStudent) throws SQLException {
        if (sr.getStudentByNationalCode(nationalCode)==null || newStudent==null){
            throw new IllegalArgumentException("student is null");
        }else {
            return sr.updateStudent(newStudent);

        }
    }

    @Override
    public Student getStudentNationalCode(String nationalCode) throws SQLException {
        if (sr.getStudentByNationalCode(nationalCode)==null){
            throw new IllegalArgumentException("nationalCode already exists");
        }else {
            return sr.getStudentByNationalCode(nationalCode);
        }
    }

    @Override
    public boolean signInStudent(int studentId, String nationalCode) throws SQLException {
        Student student = sr.getStudentByIdAndNationalCode(studentId,nationalCode);
        if (student != null) {
            SecurityContext.student = student;
            return true;
        }
        return false;
    }
}
