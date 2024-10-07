package repository.impl;

import data.Database;
import model.dto.CourseDto;
import repository.CourseStudentRepository;
import util.SecurityContext;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static data.Query.*;

public class CourseStudentRepositoryImpl implements CourseStudentRepository {
    private Database database = new Database();



    @Override
    public List<CourseDto> getCourses() throws SQLException {
        PreparedStatement pst =database.getDatabaseConnection().prepareStatement(GET_USER_COURSES);
        pst.setLong(1, SecurityContext.student.getStudentId());
        ResultSet rs = pst.executeQuery();
        List<CourseDto> courses = new ArrayList<>();
        while (rs.next()) {
            courses.add(new CourseDto(
                            rs.getString("course_title"),
                            rs.getInt("course_unit"),
                            rs.getString("teacherName"),
                            rs.getDate("exam_date").toLocalDate(),
                            rs.getTime("exam_time").toLocalTime()
                    )
            );
        }
        return courses;
    }
    @Override
    public boolean addCourse(int courseId, int studentId,String national_cod) throws SQLException {
        // Insert into courses_students
        PreparedStatement pst1 =database.getDatabaseConnection().prepareStatement(ADD_COURSE_STUDENT);
        pst1.setInt(1, courseId);
        pst1.setInt(2, studentId);
        pst1.setString(3,national_cod);
        pst1.executeUpdate();


        // Find exam_id for the student
        PreparedStatement pst2 =database.getDatabaseConnection().prepareStatement(FIND_EXAM_STUDENT);
        pst2.setInt(1, studentId);
        ResultSet rs = pst2.executeQuery();

        // Insert into exams_students
        if (rs.next()) {
            PreparedStatement pst3 =database.getDatabaseConnection().prepareStatement(ADD_EXAM_STUDENT);
            pst3.setInt(1, rs.getInt("exam_id"));
            pst3.setInt(2, studentId);
            pst3.setString(3, national_cod);
            pst3.executeUpdate();
        } else {
            System.out.println("No exam found for the student.");
        }

        return true;
    }

    @Override
    public boolean deleteCourse(int courseId, int studentId) {
        return false;
    }

}


