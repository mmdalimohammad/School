package service;

import model.Course;

import java.sql.SQLException;
import java.util.Optional;

public interface CourseService {
    boolean createCourse(Course course)throws SQLException;
    boolean updateCourse(String title,Course newcourse)throws SQLException;
    boolean deleteCourse(String title)throws SQLException;
    Optional<Course> getCourseByTitle(String title)throws SQLException;
    void printAllCoursesList();

}
