package repository.impl;


import model.dto.CourseDto;
import repository.CourseStudentRepository;
import util.SecurityContext;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static data.Query.*;
import static data.Database.*;

public class CourseStudentRepositoryImpl implements CourseStudentRepository {




    @Override
    public List<CourseDto> getCourses() throws SQLException {
        PreparedStatement pst =getPreparedStatement(GET_USER_COURSES);
        pst.setLong(1, SecurityContext.student.getStudentId());
        ResultSet rs = pst.executeQuery();
        return getCourseDtos(rs);
    }
    @Override
    public boolean addCourse(int courseId, long studentId,String national_cod) throws SQLException {
        PreparedStatement pst1 =getPreparedStatement(ADD_COURSE_STUDENT);
        pst1.setInt(1, courseId);
        pst1.setLong(2, studentId);
        pst1.setString(3,national_cod);
        pst1.executeUpdate();

        PreparedStatement pst2 =getPreparedStatement(FIND_EXAM_STUDENT);
        pst2.setLong(1, studentId);
        ResultSet rs = pst2.executeQuery();

        if (rs.next()) {
            PreparedStatement pst3 =getPreparedStatement(ADD_EXAM_STUDENT);
            pst3.setInt(1, rs.getInt("exam_id"));
            pst3.setLong(2, studentId);
            pst3.setString(3, national_cod);
            pst3.executeUpdate();
        } else {
            System.out.println("No exam found for the student.");
        }

        return true;
    }

    @Override
    public boolean deleteCourse(int courseId, long studentId,String nationalCode) throws SQLException {
        PreparedStatement pst1 = getPreparedStatement(DELETE_COURSE_STUDENT);
        pst1.setInt(1, courseId);
        pst1.setLong(2, studentId);
        pst1.setString(3, nationalCode);

        pst1.executeUpdate();
        PreparedStatement pst2 = getPreparedStatement(FIND_EXAM_STUDENT);
        pst2.setInt(1, courseId);
        ResultSet rs = pst2.executeQuery();
        if (rs.next()) {
            PreparedStatement pst3 = getPreparedStatement(DELETE_EXAM_STUDENT);
            pst3.setInt(1, rs.getInt("exam_id"));
            pst3.executeUpdate();
        }
        return true;
    }

    @Override
    public int getCountCourseStudent(int courseId,long studentId) throws SQLException {

        PreparedStatement preparedStatement =getPreparedStatement(GET_COUNT_COURSE_STUDENT);
        preparedStatement.setInt(1, courseId);
        preparedStatement.setLong(2, studentId);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            return  rs.getInt("count");
        }
     return 0;
    }

    static List<CourseDto> getCourseDtos(ResultSet rs) throws SQLException {
        List<CourseDto> courses = new ArrayList<>();
        while (rs.next()) {
            courses.add(new CourseDto(
                            rs.getString("course_title"),
                            rs.getInt("course_unit"),
                            rs.getString("teachername"),
                            rs.getDate("date").toLocalDate(),
                            rs.getTime("time").toLocalTime()
                    )
            );
        }
        return courses;
    }

}


