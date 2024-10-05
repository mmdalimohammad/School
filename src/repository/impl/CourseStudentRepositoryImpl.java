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
    public boolean addCourse(int courseId, int studentId) {
        return false;
    }

    @Override
    public boolean deleteCourse(int courseId, int studentId) {
        return false;
    }

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

}


