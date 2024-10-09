package repository.impl;

import data.Database;

import model.Course;
import model.dto.CourseDto;
import repository.CourseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static data.Query.*;

public class CourseRepositoryImpl implements CourseRepository {

    private Database database = new Database();



    @Override
    public Course addCourse(Course course) throws SQLException {
        PreparedStatement pst = database.getDatabaseConnection().prepareStatement(ADD_NEW_COURSE_DATA);
        pst.setString(1, course.getCourseTitle());
        pst.setInt(2, course.getCourseUnit());
        pst.executeUpdate();
        return getCourseByTitle(course.getCourseTitle());

    }


    @Override
    public boolean updateCourse(Course course) throws SQLException {
        PreparedStatement pst= database.getDatabaseConnection().prepareStatement(UPDATE_COURSE_DATA);
        pst.setString(1, course.getCourseTitle());
        pst.setInt(2, course.getCourseUnit());
        pst.setInt(3, course.getCourseId());
        return pst.executeUpdate() > 0;
    }

    @Override
    public boolean deleteCourse(Course course) throws SQLException {

        PreparedStatement pst1=database.getDatabaseConnection().prepareStatement(REMOVE_EXAM_COURSE);
        pst1.setInt(1, course.getCourseId());
        pst1.executeUpdate();
        PreparedStatement pst2=database.getDatabaseConnection().prepareStatement(REMOVE_COURSE_STUDENT_COURSE);
        pst2.setInt(1, course.getCourseId());
        pst2.executeUpdate();
        PreparedStatement pst=database.getDatabaseConnection().prepareStatement(REMOVE_COURSE_DATA);
        pst.setInt(1, course.getCourseId());
        pst.executeUpdate();
        return true;
    }

    @Override
    public List<Course> getAllCourses() throws SQLException {
        ResultSet courseResult=database.getSqlStatement().executeQuery(GET_ALL_COURSE);
        List<Course> courses=new ArrayList<>();
        while (courseResult.next()) {
            Course course=new Course(
                    courseResult.getInt("course_id"),
                    courseResult.getString("course_title"),
                    courseResult.getInt("course_unit")
            );
            courses.add(course);
        }
        return courses;
    }

    @Override
    public Course getCourseByTitle(String courseTitle) throws SQLException {
        PreparedStatement pst=database.getDatabaseConnection().prepareStatement(GET_COURSE_FIND_BY_TITLE);
        pst.setString(1, courseTitle);
        ResultSet rs=pst.executeQuery();
        if(rs.next()) {
            return new Course(
                    rs.getInt("course_id"),
                    rs.getString("course_title"),
                    rs.getInt("course_unit")
            );
        }
        return null;
    }

    @Override
    public List<CourseDto> getAllCoursesDto() throws SQLException {
        PreparedStatement pst=database.getDatabaseConnection().prepareStatement(GET_ALL_COURSE_DTO);
        ResultSet rs=pst.executeQuery();
        List<CourseDto> coursesDto=new ArrayList<>();
        while (rs.next()) {
            CourseDto courseDto=new CourseDto(
                    rs.getString("course_title"),
                    rs.getInt("course_unit"),
                    rs.getString("teacher_name"),
                    rs.getDate("date").toLocalDate(),
                    rs.getTime("time").toLocalTime()
            );
        }
        return coursesDto;
    }

}
