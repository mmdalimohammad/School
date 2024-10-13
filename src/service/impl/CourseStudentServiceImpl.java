package service.impl;

import model.Course;
import model.dto.CourseDto;
import repository.CourseRepository;
import repository.CourseStudentRepository;
import service.CourseStudentService;
import util.ApplicationContext;
import util.SecurityContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CourseStudentServiceImpl implements CourseStudentService {
    private final CourseStudentRepository csr;
    private final CourseRepository cr;


    public CourseStudentServiceImpl(CourseStudentRepository csr, CourseRepository cr) {
        this.csr = csr;
        this.cr = cr;
    }

    @Override
    public List<CourseDto> getCourses() throws SQLException {
        if (csr.getCourses() == null) {
            return null;
        }
        return csr.getCourses();
    }

    @Override
    public boolean addCourse(String courseTitle) throws SQLException {
        Optional<Course>optionalCourse=cr.getCourseByTitle(courseTitle);

        if (optionalCourse.isEmpty()) {
            throw new SQLException("Course not found");
        }
        if (csr.getCountCourseStudent(optionalCourse.get().getCourseId(), SecurityContext.student.getStudentId())==0) {
            return csr.addCourse(optionalCourse.get().getCourseId(), SecurityContext.student.getStudentId(), SecurityContext.student.getNationalCode());
        } else {
            throw new SQLException("Course not found");
        }
    }

    public void showMyCourses() {
        try {
            List<CourseDto> courses = ApplicationContext.getCourseStudentService().getCourses();
            System.out.printf("\u001B[35m" + "%-13s %-13s %-25s %-13s %-13s\n", "title", "credit", "teacher", "exam date", "exam time");
            for (CourseDto course : courses) {
                System.out.printf("\u001B[35m" + "%-13s %-13s %-25s %-13s %-13s\n", course.getCourseTitle(), course.getCourseUnit(), course.getTeacherName(), course.getExamDate(), course.getExamTime());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\033[0m");
    }

    @Override
    public boolean removeCourse(String courseTitle) throws SQLException {
            Optional<Course>optionalCourse=cr.getCourseByTitle(courseTitle);

        if (optionalCourse.isEmpty()) {
            throw new SQLException("Course not found");
        }
        return csr.deleteCourse(optionalCourse.get().getCourseId(), SecurityContext.student.getStudentId(), SecurityContext.student.getNationalCode());
    }
}
