package service;

import model.Course;

import java.sql.SQLException;

public interface CourseService {
    boolean createCourse(Course course)throws SQLException;
    boolean updateCourse(String title,Course newcourse)throws SQLException;
    boolean deleteCourse(String title)throws SQLException;
    Course getCourseByTitle(String title)throws SQLException;
    void printAllCoursesList();
    Course generateCourse(int id,String title,int unit)throws SQLException;
}
