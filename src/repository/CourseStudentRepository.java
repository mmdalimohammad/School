package repository;

import model.Course;
import model.dto.CourseDto;

import java.sql.SQLException;
import java.util.List;

public interface CourseStudentRepository {

    List<CourseDto> getCourses() throws SQLException;
    boolean addCourse(int courseId,long studentId,String national_code) throws SQLException;
    boolean deleteCourse(int courseId,long studentId,String nationalCode)throws SQLException;



}
