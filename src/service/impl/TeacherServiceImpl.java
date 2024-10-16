package service.impl;

import model.Student;
import model.Teacher;
import model.dto.StudentDto;
import repository.BaseRepository;
import repository.StudentRepository;
import repository.TeacherRepository;
import service.TeacherService;
import util.SecurityContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TeacherServiceImpl implements TeacherService {


    private TeacherRepository tr;
    private StudentRepository sr;


    public TeacherServiceImpl(TeacherRepository tr, StudentRepository sr) {
        this.tr = tr;
        this.sr = sr;
    }

    @Override
    public void printAllList() {
        try {
            List<Teacher> teachers = tr.getAll();
            System.out.format("\033[1;35m"+"+------+----------------+---------------+---------------+%n");
            System.out.format("\033[1;35m"+"| ID   | first name     | last name     | national code |%n");
            System.out.format("\033[1;35m"+"+------+----------------+---------------+---------------+%n");
            for (Teacher teacher : teachers) {
                System.out.printf("\033[1;35m"+"|"+"\033[1;34m"+" %-4s"+"\033[1;35m"+" |"+"\033[1;34m"+" %-14s"+"\033[1;35m"+" |"+"\033[1;34m"+" %-13s"+"\033[1;35m"+" |"+"\033[1;34m"+" %-14s"+"\033[1;35m"+"|"+"\n",
                        teacher.getTeacherId(),
                        teacher.getFirstName(),
                        teacher.getLastName(),
                        teacher.getNationalCode());
            }
            System.out.format("\033[1;35m"+"+------+----------------+---------------+---------------+%n");
        } catch (SQLException sqlException) {
            System.out.println("there is problem with connecting to database");
        }
        System.out.println("\033[0m");
    }


    @Override
    public boolean add(Teacher teacher) throws SQLException {
        if (teacher==null) {
            throw new IllegalArgumentException("teacher cannot be null");
        }
        return tr.add(teacher);
    }



    @Override
    public boolean remove(String nationalCode) throws SQLException {
        Optional<Teacher> teacher=tr.getByNationalCode(nationalCode);
        if (teacher.isEmpty()) {
            throw new IllegalArgumentException("teacher not found");
        }else {
            return tr.remove(teacher.get());
        }

    }


    @Override
    public boolean update(String nationalCode, Teacher newTeacher) throws SQLException {
        Optional<Teacher> teacher=tr.getByNationalCode(nationalCode);
        if (teacher.isEmpty()) {
            throw new IllegalArgumentException("teacher is null");
        } else {
            tr.update(newTeacher);
            return true;
        }
    }

    @Override
    public Optional<Teacher> getNationalCode(String nationalCode) throws SQLException {
        if (tr.getByNationalCode(nationalCode).isEmpty()) {
            throw new IllegalArgumentException("nationalCode already exists");
        } else {
            return tr.getByNationalCode(nationalCode);
        }
    }

    @Override
    public boolean signInTeacher(int teacherId, String nationalCode) throws SQLException {
        Optional<Teacher> teacher=tr.getByIdAndNationalCode(teacherId,nationalCode);
        if (teacher.isPresent()) {
            SecurityContext.teacher = teacher.get();
            return true;
        }
        return false;
    }

    @Override
    public void printAllStudent() {
        try {
            List<StudentDto> studentDto = tr.getAllStudent();
            System.out.format("\033[1;35m"+"+------+----------------+---------------+--------+%n");
            System.out.format("\033[1;35m"+"| ID   | full name      | national code | score  |%n");
            System.out.format("\033[1;35m"+"+------+----------------+---------------+--------+%n");
            for (StudentDto student : studentDto) {
                System.out.printf("\033[1;35m"+"|"+"\033[1;34m"+" %-4s"+"\033[1;35m"+" |"+"\033[1;34m"+" %-14s"+"\033[1;35m"+" |"+"\033[1;34m"+" %-13s"+"\033[1;35m"+" |"+"\033[1;34m"+" %-7s"+"\033[1;35m"+"|"+"\n",
                        student.getStudentId(),
                        student.getFullName(),
                        student.getNationalCode(),
                        student.getGpu());
            }
            System.out.format("\033[1;35m"+"+------+----------------+---------------+--------+%n");
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        System.out.println("\033[0m");
    }


    @Override
    public boolean addScore(String nationalCode,int courseId,double score) throws SQLException {
        Optional<Student>optionalStudent=sr.getByNationalCode(nationalCode);
        if (optionalStudent.isEmpty()) {
            throw new IllegalArgumentException("student not found");
        } else if (score > 20.0 || score < 0.0) {
            throw new IllegalArgumentException("Avg score cannot be more than 20.0 or less than 0.0");
        }
        return tr.addScore(optionalStudent.get().getStudentId(),courseId,score);
    }



}
