package repository.impl;

import model.Student;
import repository.StudentRepository;
import data.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                    studentsResult.getDate("dob"),
                    studentsResult.getString("national_code"),
                    studentsResult.getDouble("gpu")

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
        pst.setString(3, student.getNationalCode());
        pst.executeUpdate();
        return true;
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
        PreparedStatement pst=database.getDatabaseConnection().prepareStatement(GET_STUDENT_FIND_BY_NATIONAL_CODE);
        pst.setString(1, nationalCode);
        ResultSet rs=pst.executeQuery();
        if (rs.next()) {
            return new Student(
                    rs.getLong("student_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("national_code")

            );
        }
        return null;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        PreparedStatement pst=database.getDatabaseConnection().prepareStatement(UPDATE_STUDENT_DATA);
        pst.setString(1, student.getFirstName());
        pst.setString(2, student.getLastName());
        pst.setString(3, student.getNationalCode());
        pst.executeUpdate();
        return true;
    }
}


