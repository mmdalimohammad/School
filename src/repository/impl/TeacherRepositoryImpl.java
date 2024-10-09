package repository.impl;

import model.Teacher;
import repository.TeacherRepository;
import data.Database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static data.Query.*;

public class TeacherRepositoryImpl implements TeacherRepository {
    //language=sql



    private Database database = new Database();

    @Override
    public List<Teacher> getAllTeacher() throws SQLException {
        ResultSet teacherResult = database.getSqlStatement().executeQuery(GET_ALL_TEACHER_QUERY);
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
    public int getCountOfTeacher() throws SQLException {
        ResultSet countResult = database.getSqlStatement().executeQuery(GET_COUNT_OF_TEACHER);
        int teacherCount = 0;
        while (countResult.next()) {
            teacherCount = countResult.getInt("count");
        }
        return teacherCount;
    }

    @Override
    public boolean createTeacher(Teacher teacher) throws SQLException {
        PreparedStatement pst =database.getDatabaseConnection().prepareStatement(ADD_TEACHER_DATA);
        pst.setString(1, teacher.getFirstName());
        pst.setString(2, teacher.getLastName());
        pst.setDate(3, Date.valueOf(teacher.getDob()));
        pst.setString(4, teacher.getNationalCode());
        pst.setInt(5,teacher.getCourseID());
        pst.executeUpdate();
        return true;
    }

    @Override
    public boolean removeTeacher(Teacher teacher) throws SQLException {
        PreparedStatement pst=database.getDatabaseConnection().prepareStatement(REMOVE_TEACHER_DATA);
        pst.setLong(1,teacher.getTeacherId());
        pst.executeUpdate();
        return true;
    }

    @Override
    public Teacher getTeacherByNationalCode(String nationalCode) throws SQLException {
        PreparedStatement pst=database.getDatabaseConnection().prepareStatement(GET_TEACHER_FIND_BY_NATIONAL_CODE);
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
    public boolean updateTeacher(Teacher teacher) throws SQLException {
        PreparedStatement pst=database.getDatabaseConnection().prepareStatement(UPDATE_TEACHER_DATA);
        pst.setString(1,teacher.getFirstName());
        pst.setString(2,teacher.getLastName());
        pst.setString(3,teacher.getNationalCode());
        pst.executeUpdate();
        return true;
    }

    @Override
    public Teacher getTeacherByIdAndNationalCode(int id, String nationalCode) throws SQLException {
        PreparedStatement pst=database.getDatabaseConnection().prepareStatement(GET_TEACHER_BY_ID_NATIONAL_CODE);
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
}
