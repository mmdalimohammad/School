package repository;

import model.Course;
import model.dto.CourseDto;

import java.sql.SQLException;
import java.util.List;

public interface CourseStudentRepository {
    boolean addCourse(int courseId,int studentId);
    boolean deleteCourse(int courseId,int studentId);
    List<CourseDto> getCourses() throws SQLException;

}
