package repository.impl;

import model.Student;
import repository.StudentRepository;
import data.Database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import static data.Query.*;

public class StudentRepositoryImpl implements StudentRepository {
    //language=sql


    private Database database = new Database();


    @Override
    public List<Student> getAllStudents() throws SQLException {
        ResultSet studentsResult = database.getSqlStatement().executeQuery(GET_ALL_STUDENT_QUERY);
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
    public int getCountOfStudent() throws SQLException {
        ResultSet countResult = database.getSqlStatement().executeQuery(GET_COUNT_OF_STUDENT);
        int studentCount = 0;
        while (countResult.next()) {
            studentCount = countResult.getInt("count");
        }
        return studentCount;
    }


    @Override
    public boolean createStudent(Student student) throws SQLException {

        PreparedStatement pst = database.getDatabaseConnection().prepareStatement(ADD_STUDENT_DATA);
        pst.setString(1, student.getFirstName());
        pst.setString(2, student.getLastName());
        pst.setDate(3, Date.valueOf(student.getDob()));
        pst.setString(4, student.getNationalCode());
        ;
        return pst.executeUpdate() > 0;
    }

    @Override
    public boolean removeStudent(Student student) throws SQLException {
        PreparedStatement pst = database.getDatabaseConnection().prepareStatement(REMOVE_STUDENTS_DATA);
        pst.setLong(1, student.getStudentId());
        int affectedRows = pst.executeUpdate();
        return affectedRows > 0;
    }

    @Override
    public Student getStudentByNationalCode(String nationalCode) throws SQLException {
        PreparedStatement pst = database.getDatabaseConnection().prepareStatement(GET_STUDENT_FIND_BY_NATIONAL_CODE);
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
    public boolean updateStudent(Student student) throws SQLException {
        PreparedStatement pst = database.getDatabaseConnection().prepareStatement(UPDATE_STUDENT_DATA);
        pst.setString(1, student.getFirstName());
        pst.setString(2, student.getLastName());
        pst.setDate(2, Date.valueOf(student.getDob()));
        pst.setString(4, student.getNationalCode());
        pst.executeUpdate();
        return true;
    }

    @Override
    public Student getStudentByIdAndNationalCode(int id, String nationalCode) throws SQLException {
        PreparedStatement pst = database.getDatabaseConnection().prepareStatement(GET_STUDENT_BY_ID_NATIONAL_CODE);
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



