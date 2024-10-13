package repository;

import model.Course;
import model.dto.CourseDto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    boolean addCourse(Course course)throws SQLException;
    boolean updateCourse(Course course) throws SQLException;
    boolean deleteCourse(Course course) throws SQLException;
    List<Course> getAllCourses() throws SQLException;
    Optional<Course> getCourseByTitle(String courseTitle) throws SQLException;
    List<CourseDto> getAllCoursesDto() throws SQLException;


}
