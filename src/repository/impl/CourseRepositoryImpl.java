package repository.impl;



import model.Course;
import model.dto.CourseDto;
import repository.CourseRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static data.Query.*;
import static data.Database.*;

public class CourseRepositoryImpl implements CourseRepository {





    @Override
    public Course addCourse(Course course) throws SQLException {
        PreparedStatement pst =getPreparedStatement(ADD_NEW_COURSE_DATA);
        pst.setString(1, course.getCourseTitle());
        pst.setInt(2, course.getCourseUnit());
        pst.executeUpdate();
        return getCourseByTitle(course.getCourseTitle());

    }


    @Override
    public boolean updateCourse(Course course) throws SQLException {
        PreparedStatement pst= getPreparedStatement(UPDATE_COURSE_DATA);
        pst.setString(1, course.getCourseTitle());
        pst.setInt(2, course.getCourseUnit());
        pst.setInt(3, course.getCourseId());
        return pst.executeUpdate() > 0;
    }

    @Override
    public boolean deleteCourse(Course course) throws SQLException {

        PreparedStatement pst1=getPreparedStatement(REMOVE_EXAM_COURSE);
        pst1.setInt(1, course.getCourseId());
        pst1.executeUpdate();
        PreparedStatement pst2=getPreparedStatement(REMOVE_COURSE_STUDENT_COURSE);
        pst2.setInt(1, course.getCourseId());
        pst2.executeUpdate();
        PreparedStatement pst=getPreparedStatement(REMOVE_COURSE_DATA);
        pst.setInt(1, course.getCourseId());
        pst.executeUpdate();
        return true;
    }

    @Override
    public List<Course> getAllCourses() throws SQLException {
        PreparedStatement pst=getPreparedStatement(GET_ALL_COURSE);
        ResultSet courseResult=pst.executeQuery();
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
        PreparedStatement pst=getPreparedStatement(GET_COURSE_FIND_BY_TITLE);
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
        PreparedStatement pst=getPreparedStatement(GET_ALL_COURSE_DTO);
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
