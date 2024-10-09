package service.impl;

import model.Teacher;
import model.dto.CourseDto;
import repository.TeacherRepository;
import service.TeacherService;
import util.ApplicationContext;
import util.SecurityContext;

import java.sql.SQLException;
import java.util.List;

public class TeacherServiceImpl implements TeacherService {


    private TeacherRepository tr;
    public  TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.tr=teacherRepository;
    }


    @Override
    public void printAllTeacherList() {
        try {
            List<Teacher> teachers = tr.getAllTeacher();
            System.out.printf("\u001B[35m"+"%-7s %-17s %-13s %-17s\n", "id", "first name", "last name", "national code");
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
    public void printCountOfTeacher() {
        try {
            int countOfTeacher = tr.getCountOfTeacher();
            System.out.println("# teacher: ".concat(String.valueOf(countOfTeacher)));
        } catch (SQLException sqlException) {
            System.out.println("there is problem with connecting to database");
        }
    }

    @Override
    public boolean createTeacher(Teacher teacher) throws SQLException {
        if (teacher==null){
            throw new IllegalArgumentException("teacher cannot be null");
        }
        return tr.createTeacher(teacher);
    }

    @Override
    public Teacher generateTeacher(String firstName, String lastName, String nationalCode) throws SQLException {
        if (tr.getTeacherByNationalCode(nationalCode)!=null){
            throw new IllegalArgumentException("teacher already exists");
        }else {
            return new Teacher(firstName, lastName, nationalCode);
        }
    }

    @Override
    public boolean removeTeacher(String nationalCode) throws SQLException {
    return tr.removeTeacher(tr.getTeacherByNationalCode(nationalCode));
    }

    @Override
    public boolean updateTeacher(String nationalCode, Teacher newTeacher) throws SQLException {
        if (tr.getTeacherByNationalCode(nationalCode)==null || newTeacher==null){
            throw new IllegalArgumentException("teacher is null");
        }else {
            tr.updateTeacher(newTeacher);
            return true;
        }
    }

    @Override
    public Teacher getTeacherNationalCode(String nationalCode) throws SQLException {
        if (tr.getTeacherByNationalCode(nationalCode)==null){
            throw new IllegalArgumentException("nationalCode already exists");
        }else {
            return tr.getTeacherByNationalCode(nationalCode);
        }
    }

    @Override
    public boolean signInTeacher(int teacherId, String nationalCode) throws SQLException {
     Teacher teacher=tr.getTeacherByIdAndNationalCode(teacherId,nationalCode);
     if (teacher!=null){
         SecurityContext.teacher = teacher;
         return true;
     }
     return false;
    }


}
