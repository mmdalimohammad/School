package service.impl;

import model.Teacher;
import model.dto.StudentDto;
import repository.BaseRepository;
import repository.TeacherRepository;
import service.TeacherService;
import util.SecurityContext;

import java.sql.SQLException;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {


    private TeacherRepository tr;

    public TeacherServiceImpl(TeacherRepository tr) {
        this.tr = tr;
    }

    @Override
    public void printAllList() {
        try {
            List<Teacher> teachers = tr.getAll();
            System.out.printf("\u001B[35m" + "%-7s %-17s %-13s %-17s\n", "id", "first name", "last name", "national code");
            for (Teacher teacher : teachers) {
                System.out.printf("%-7s %-17s %-13s %-17s\n",
                        teacher.getTeacherId(),
                        teacher.getFirstName(),
                        teacher.getLastName(),
                        teacher.getNationalCode());
            }
        } catch (SQLException sqlException) {
            System.out.println("there is problem with connecting to database");
        }
        System.out.println("\033[0m");
    }


    @Override
    public boolean add(Teacher teacher) throws SQLException {
        if (teacher == null) {
            throw new IllegalArgumentException("teacher cannot be null");
        }
        return tr.add(teacher);
    }

    @Override
    public Teacher generate(String firstName, String lastName, String nationalCode) throws SQLException {
        if (tr.getByNationalCode(nationalCode) != null) {
            throw new IllegalArgumentException("teacher already exists");
        } else {
            return new Teacher(firstName, lastName, nationalCode);
        }
    }

    @Override
    public boolean remove(String nationalCode) throws SQLException {
        return tr.remove(tr.getByNationalCode(nationalCode));
    }

    @Override
    public boolean update(String nationalCode, Teacher newTeacher) throws SQLException {
        if (tr.getByNationalCode(nationalCode) == null || newTeacher == null) {
            throw new IllegalArgumentException("teacher is null");
        } else {
            tr.update(newTeacher);
            return true;
        }
    }

    @Override
    public Teacher getNationalCode(String nationalCode) throws SQLException {
        if (tr.getByNationalCode(nationalCode) == null) {
            throw new IllegalArgumentException("nationalCode already exists");
        } else {
            return tr.getByNationalCode(nationalCode);
        }
    }

    @Override
    public boolean signInTeacher(int teacherId, String nationalCode) throws SQLException {
        Teacher teacher = tr.getByIdAndNationalCode(teacherId, nationalCode);
        if (teacher != null) {
            SecurityContext.teacher = teacher;
            return true;
        }
        return false;
    }

    @Override
    public void printAllStudent() {
        try {
            List<StudentDto> studentDto = tr.getAllStudent();
            System.out.printf("\u001B[35m" + "%-7s %-17s %-13s %-17s\n", "id", "full name", "national code", "score");
            for (StudentDto student : studentDto) {
                System.out.printf("%-7s %-17s %-13s %-17s\n",
                        student.getStudentId(),
                        student.getFullName(),
                        student.getNationalCode(),
                        student.getGpu());
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        System.out.println("\033[0m");
    }


}
