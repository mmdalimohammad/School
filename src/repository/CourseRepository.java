package repository;

import model.Course;
import model.dto.CourseDto;

import java.sql.SQLException;
import java.util.List;

public interface CourseRepository {
    Course addCourse(Course course)throws SQLException;
    boolean updateCourse(Course course) throws SQLException;
    boolean deleteCourse(Course course) throws SQLException;
    List<Course> getAllCourses() throws SQLException;
    Course getCourseByTitle(String courseTitle) throws SQLException;
    List<CourseDto> getAllCoursesDto() throws SQLException;


}
