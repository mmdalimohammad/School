package service.impl;

import model.dto.CourseDto;
import repository.CourseStudentRepository;
import service.CourseStudentService;

import java.sql.SQLException;
import java.util.List;

public class CourseStudentServiceImpl implements CourseStudentService {
    private final CourseStudentRepository ctr;

    public CourseStudentServiceImpl(CourseStudentRepository ctr) {
        this.ctr = ctr;
    }

    @Override
    public List<CourseDto> getCourses() throws SQLException {
        if (ctr.getCourses() == null) {
            return null;
        }
        return ctr.getCourses();
    }
}
