package service.impl;

import model.Course;
import repository.CourseRepository;
import service.CourseService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CourseServiceImpl implements CourseService {
    private CourseRepository cr;


    public CourseServiceImpl(CourseRepository cr) {
        this.cr = cr;
    }

    @Override
    public boolean createCourse(Course course) throws SQLException {
        if (course==null) {
            throw new SQLException("Course is null");
        }else {
            return cr.addCourse(course);
        }
    }

    @Override
    public boolean updateCourse(String title,Course newcourse) throws SQLException {
        Optional<Course>optionalCourse=cr.getCourseByTitle(title);

        if (optionalCourse.isEmpty() || newcourse == null) {
            throw new IllegalArgumentException("Course is null");
        }else {
            newcourse.setCourseId(optionalCourse.get().getCourseId());
           return cr.updateCourse(newcourse);
        }
    }

    @Override
    public boolean deleteCourse(String title) throws SQLException {
        Optional<Course> course = cr.getCourseByTitle(title);
        return cr.deleteCourse(course.get());
    }

    @Override
    public Optional<Course> getCourseByTitle(String title) throws SQLException {
        if (cr.getCourseByTitle(title).isPresent()) {
            throw new IllegalArgumentException("Course already exists");
        }else {
            return cr.getCourseByTitle(title);
        }
    }

    @Override
    public void printAllCoursesList(){
        try {
            List<Course>courses = cr.getAllCourses();
            System.out.printf("\u001B[35m"+"%-13s %-16s %-16s \n", "course id", "course title", "course unit");
            for (Course course : courses) {
                System.out.printf("%-13s %-16s %-16s \n",
                        course.getCourseId(),
                        course.getCourseTitle(),
                        course.getCourseUnit());
            }
        }catch (SQLException sqlException){
            System.out.println("there is problem with connecting to database");
        }
        System.out.println("\033[0m");
    }

}
