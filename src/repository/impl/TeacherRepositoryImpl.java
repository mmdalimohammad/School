package repository.impl;

import model.Teacher;
import model.dto.StudentDto;
import repository.BaseRepository;
import repository.TeacherRepository;
import util.SecurityContext;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static data.Query.*;
import static data.Database.*;

public class TeacherRepositoryImpl implements TeacherRepository {

    @Override
    public List<Teacher> getAll() throws SQLException {
        PreparedStatement pst = getPreparedStatement(GET_ALL_TEACHER_QUERY);
        ResultSet teacherResult = pst.executeQuery();
        List<Teacher> teachers = new ArrayList<>();
        while (teacherResult.next()) {
            Teacher teacher = new Teacher(
                    teacherResult.getLong("teacher_id"),
                    teacherResult.getString("first_name"),
                    teacherResult.getString("last_name"),
                    teacherResult.getDate("dob").toLocalDate(),
                    teacherResult.getString("national_code"),
                    teacherResult.getInt("course_id")
            );
            teachers.add(teacher);
        }
        return teachers;
    }


    @Override
    public boolean add(Teacher teacher) throws SQLException {
        PreparedStatement pst =getPreparedStatement(ADD_TEACHER_DATA);
        pst.setString(1, teacher.getFirstName());
        pst.setString(2, teacher.getLastName());
        pst.setDate(3, Date.valueOf(teacher.getDob()));
        pst.setString(4, teacher.getNationalCode());
        pst.setInt(5,teacher.getCourseID());
        pst.executeUpdate();
        return true;
    }

    @Override
    public boolean remove(Teacher teacher) throws SQLException {
        PreparedStatement pst=getPreparedStatement(REMOVE_TEACHER_DATA);
        pst.setLong(1,teacher.getTeacherId());
        pst.executeUpdate();
        return true;
    }



    @Override
    public Teacher getByNationalCode(String nationalCode) throws SQLException {
        PreparedStatement pst=getPreparedStatement(GET_TEACHER_FIND_BY_NATIONAL_CODE);
        pst.setString(1,nationalCode);
        ResultSet resultSet=pst.executeQuery();
        if (resultSet.next()) {
            return new Teacher(
                    resultSet.getLong("teacher_id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("national_code")
            );
        }
        return null;
    }

    @Override
    public boolean update(Teacher teacher) throws SQLException {
        PreparedStatement pst=getPreparedStatement(UPDATE_TEACHER_DATA);
        pst.setString(1,teacher.getFirstName());
        pst.setString(2,teacher.getLastName());
        pst.setString(3,teacher.getNationalCode());
        pst.executeUpdate();
        return true;
    }

    @Override
    public Teacher getByIdAndNationalCode(int id, String nationalCode) throws SQLException {
        PreparedStatement pst=getPreparedStatement(GET_TEACHER_BY_ID_NATIONAL_CODE);
        pst.setLong(1,id);
        pst.setString(2,nationalCode);
        ResultSet rt=pst.executeQuery();
        if (rt.next()) {
            return new Teacher(
                    rt.getLong("teacher_id"),
                    rt.getString("first_name"),
                    rt.getString("last_name"),
                    rt.getDate("dob").toLocalDate(),
                    rt.getString("national_code")
            );
        }
        return null;
    }

    @Override
    public List<StudentDto> getAllStudent() throws SQLException {
        PreparedStatement pst=getPreparedStatement(GET_USER_STUDENT);
        pst.setLong(1, SecurityContext.teacher.getTeacherId());
        ResultSet rs=pst.executeQuery();
        List<StudentDto> students = new ArrayList<>();
        while (rs.next()) {
            students.add(new StudentDto(
                    rs.getInt("student_id"),
                    rs.getString("full_name"),
                    rs.getString("national_Code"),
                    rs.getDouble("gpu")
            ));

        }
        return students;
    }
}
