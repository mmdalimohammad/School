package repository.impl;

import model.Student;
import repository.BaseRepository;
import repository.StudentRepository;
import data.Database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import static data.Database.*;
import static data.Query.*;

public class StudentRepositoryImpl implements StudentRepository{
    //language=sql





    @Override
    public List<Student> getAll() throws SQLException {
        PreparedStatement pst =getPreparedStatement(GET_ALL_STUDENT_QUERY);
        ResultSet studentsResult = pst.executeQuery();
        List<Student> students = new ArrayList<>();
        while (studentsResult.next()) {
            Student student = new Student(
                    studentsResult.getLong("student_id"),
                    studentsResult.getString("first_name"),
                    studentsResult.getString("last_name"),
                    studentsResult.getDate("dob").toLocalDate(),
                    studentsResult.getString("national_code")
            );
            students.add(student);
        }
        return students;
    }





    @Override
    public boolean add(Student student) throws SQLException {
        PreparedStatement pst = getPreparedStatement(ADD_STUDENT_DATA);
        pst.setString(1, student.getFirstName());
        pst.setString(2, student.getLastName());
        pst.setDate(3, Date.valueOf(student.getDob()));
        pst.setString(4, student.getNationalCode());
        return pst.executeUpdate() > 0;
    }

    @Override
    public boolean remove(Student student) throws SQLException {
        PreparedStatement pst=getPreparedStatement(REMOVE_COURSE_STUDENT_ID);
        pst.setLong(1, student.getStudentId());
        pst.executeUpdate();

        PreparedStatement pst2=getPreparedStatement(REMOVE_EXAM_STUDENT_ID);
        pst2.setLong(1, student.getStudentId());
        pst2.executeUpdate();


        PreparedStatement pst1 = getPreparedStatement(REMOVE_STUDENTS_DATA);
        pst1.setLong(1, student.getStudentId());
        int affectedRows = pst1.executeUpdate();
        return affectedRows > 0;
    }

    @Override
    public Student getByNationalCode(String nationalCode) throws SQLException {
        PreparedStatement pst =getPreparedStatement(GET_STUDENT_FIND_BY_NATIONAL_CODE);
        pst.setString(1, nationalCode);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return new Student(
                    rs.getLong("student_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    LocalDate.parse(rs.getString("dob")),
                    rs.getString("national_code")

            );
        }
        return null;
    }

    @Override
    public boolean update(Student student) throws SQLException {
        PreparedStatement pst = getPreparedStatement(UPDATE_STUDENT_DATA);
        pst.setString(1, student.getFirstName());
        pst.setString(2, student.getLastName());
        pst.setString(3, student.getNationalCode());
        pst.executeUpdate();
        return true;
    }

    @Override
    public Student getByIdAndNationalCode(int id, String nationalCode) throws SQLException {
        PreparedStatement pst = getPreparedStatement(GET_STUDENT_BY_ID_NATIONAL_CODE);
        pst.setInt(1, id);
        pst.setString(2, nationalCode);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            return new Student(
                    rs.getInt("student_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getDate("dob").toLocalDate(),
                    rs.getString("national_code")
            );
        }
        return null;
    }

}



